from decimal import Decimal, getcontext
import pandas as pd

getcontext().prec = 60

# Allele frequencies (Dutch Caucasians N=231), copied from the uploaded DVI table.
freqs = {
    "D3S1358": {"12":0,"13":0.002,"14":0.091,"15":0.281,"16":0.253,"17":0.193,"18":0.167,"19":0.011,"20":0.002,"21":0.004},
    "vWA": {"11":0,"13":0,"14":0.067,"15":0.076,"16":0.203,"17":0.303,"18":0.223,"19":0.110,"20":0.013,"21":0.004},
    "D16S539": {"8":0.015,"9":0.123,"10":0.067,"11":0.340,"12":0.279,"13":0.162,"13.3":0,"14":0.013,"15":0},
    "D2S1338": {"15":0,"16":0.048,"17":0.203,"18":0.076,"19":0.128,"20":0.171,"21":0.015,"22":0.030,"23":0.097,"24":0.095,"25":0.117,"26":0.017,"27":0.002},
    "D8S1179": {"8":0.019,"9":0.011,"10":0.078,"11":0.087,"12":0.147,"13":0.346,"14":0.180,"15":0.102,"16":0.028,"17":0.002,"18":0},
    "D21": {"27":0.017,"28":0.180,"29":0.223,"29.2":0,"30":0.271,"30.2":0.030,"31":0.078,"31.2":0.074,"32":0.011,"32.2":0.091,"33":0.002,"33.1":0,"33.2":0.022,"34":0,"34.2":0,"35":0,"35.2":0.002,"36":0},
    "D18S51": {"9":0,"10":0.011,"11":0.006,"12":0.134,"13":0.108,"14":0.182,"15":0.117,"16":0.152,"17":0.141,"18":0.071,"19":0.039,"20":0.026,"21":0.006,"22":0.004,"23":0,"25":0.002},
    "D19S433": {"9":0,"10":0.002,"11":0.004,"12":0.061,"12.2":0,"13":0.255,"13.2":0.011,"14":0.359,"14.2":0.032,"15":0.165,"15.2":0.037,"16":0.037,"16.2":0.026,"17":0.002,"17.2":0.006,"18.2":0.002},
    "THO": {"5":0.006,"6":0.225,"7":0.219,"8":0.104,"9":0.132,"9.3":0.307,"10":0.006},
    "FGA": {"18":0.013,"18.2":0,"19":0.058,"19.2":0,"20":0.145,"21":0.177,"22":0.173,"22.2":0.015,"23":0.136,"23.2":0.006,"24":0.158,"25":0.074,"25.2":0,"26":0.028,"27":0.013,"28":0.002,"29":0,"31.2":0,"45.2":0},
}
freqs = {l:{a:Decimal(str(p)) for a,p in d.items()} for l,d in freqs.items()}
loci = list(freqs)

profiles_df = pd.read_csv("11.csv")
profiles_df = profiles_df[profiles_df["type"].notna()].copy()
profiles = {}
for _, r in profiles_df.iterrows():
    key = f"{r['type']}{int(r['Identity number'])}"
    profiles[key] = {}
    for loc in loci:
        a = str(r[f"{loc}-1"]).rstrip("0").rstrip(".") if isinstance(r[f"{loc}-1"], float) else str(r[f"{loc}-1"])
        b = str(r[f"{loc}-2"]).rstrip("0").rstrip(".") if isinstance(r[f"{loc}-2"], float) else str(r[f"{loc}-2"])
        profiles[key][loc] = tuple(sorted([a,b], key=lambda x: Decimal(x)))

def geno_prob(loc, g):
    a, b = g
    pa, pb = freqs[loc][a], freqs[loc][b]
    return pa*pa if a == b else Decimal(2)*pa*pb

def child_prob(gm, gf, gc):
    out = Decimal(0)
    for ma in gm:
        for fa in gf:
            child = tuple(sorted((ma, fa), key=lambda x: Decimal(x)))
            if child == gc:
                out += Decimal("0.25")
    return out

def random_child_prob_given_mother(loc, gm, gc):
    total = Decimal(0)
    alleles = list(freqs[loc].keys())
    for i, a in enumerate(alleles):
        pa = freqs[loc][a]
        if pa == 0:
            continue
        total += pa*pa*child_prob(gm, (a, a), gc)
        for b in alleles[i+1:]:
            pb = freqs[loc][b]
            if pb == 0:
                continue
            gf = tuple(sorted((a, b), key=lambda x: Decimal(x)))
            total += Decimal(2)*pa*pb*child_prob(gm, gf, gc)
    return total

# UI3 as child of FM7 and FM8
LR_ui3 = Decimal(1)
for loc in loci:
    num = child_prob(profiles["FM7"][loc], profiles["FM8"][loc], profiles["UI3"][loc])
    den = geno_prob(loc, profiles["UI3"][loc])
    LR_ui3 *= num / den
print("UI3 vs MP6 LR =", LR_ui3)

# UI6 as father of FM2, with FM1 as known mother
LR_ui6 = Decimal(1)
for loc in loci:
    num = child_prob(profiles["FM1"][loc], profiles["UI6"][loc], profiles["FM2"][loc])
    den = random_child_prob_given_mother(loc, profiles["FM1"][loc], profiles["FM2"][loc])
    LR_ui6 *= num / den
print("UI6 vs MP1 LR =", LR_ui6)
