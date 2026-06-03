## DNA
DNA = Deoxyribo-Nucleic Acid

Mitochondria: 线粒体
chromosomes: 染色体
karyotyping: 核型
mitosis：有丝分裂
meiosis: 减数分裂 两轮细胞分裂
Genetic shuffling 基因重组

DNA Polymorphism /genomic variants: 基因多样性
Allele: 等位基因
Locus (loci): location of a gene or a marker on chromosom
Genotype: 基因型: Homozygous: AA/aa, Heterozygous: Aa
Microsatellite = Short Tandem Repeat (STR)
forensic STRs are harmonized: 15 loci from the European Standard Set

Amplification by PCR:
1. Seperate strands (denature, 94°) 
2. Add primers (anneal, 60°): Forward Primer, Reverse Primer
3. Make copies (extend primers): Tag Polymerase聚合酶, 72°

STR analysis uses PCR to amplify repeated DNA regions. Because different alleles have different numbers of repeats, they produce DNA fragments of different lengths. These fragments are separated by electrophoresis, where smaller fragments travel farther than larger ones. The final graph shows peaks at different fragment sizes.

Random match probability (RMP): $P(E_C|E_S, H_d)$, $E_C=$profile of crime stain donor, and $E_S =$ profile of suspect

LR = $\frac{1}{RMP}$

If the genotype frequencies are known numbers and C and S are unrelated, $E_C$ and $E_S$ are conditionally independent. Then the LR reduces to: $\frac{1}{\text{profile frequency}} = \frac{1}{P(E_c|H_d)}$

Hardy-Weinberg proportions:
For heterozygote: $P_{ij} =2p_ip_j$
For homozygote: $P_{ii} = p_i^2$

Theta-Formulas:

$P_{ii} = \frac{[3\theta + (1-\theta)p_i][2\theta + (1-\theta)p_i]}{(1+2\theta)(1+\theta)}$

$P_{ij} = \frac{2[\theta + (1-\theta)p_i][\theta + (1-\theta)p_j]}{(1+2\theta)(1+\theta)}$

Size bias correction
## LR validation
### histogram $log_{10}(LR)$
For a good system:
+ H1-true cases should mostly be on the right.
+ H2-true cases should mostly be on the left.
+ Little overlap means good discrimination.


### PAC-transformed:
+ Are the LR values too strong, too weak, or about right?
+ If the LR-system is well-calibrated, the PAV-transformed LRs are close to the original LRs (close to the line y=x)

Interpretation:
+ If the curve/points are close to the diagonal: good calibration.
+ If the curve is far below diagonal at high LRs: original LRs are too extreme.
+ If the curve is far above diagonal at low LRs: original LRs are too extreme in the other direction.
+ If the curve is flatter than diagonal: LRs are not using enough or too much evidential strength properly.

### Accuracy
+ x-axis: $log_{10} (\text{prior odds})$, y-axis: empirical cross-entropy, lower is better

#### ECE plots
The key lines:
+ Reference: This is the performance if you basically use no evidence, equivalent to always reporting LR=1
+ LR curve: performance after applying the LR system.
+ PAV LR curve: best possible monotonic recalibration of the LRs; it shows the system’s potential if calibration were optimized.

How to read it:
+ LR curve below reference = system adds useful information.
+ LR curve close to PAV curve = good calibration.
+ Big gap between LR and PAV = calibration problem.
+ If the curve crosses above the reference, the LR system can be harmful for those prior odds.
+ PAV curve itself indicates the best calibrated performance possible from the system’s ranking.

+ accuracy $C_{llr}$ is the value when $log_{10}(prior odds) = 0$, LR curve at x=0 (←basis for our estimate)
+ discrimination $C_{llr, min}$ PAV curve value at x=0
+ Calibration: calibration loss = $C_{llr} - C_{llr, min}$ 

## EuroForMix

### The main parameter estimates
+ Mixture proportions： e.g.: contributor 1 explains about 77% of the DNA signal, contributor 2 about 23%. C1 and C2 labels depend on the hypothesis. Under Hp, C1 may be the known suspect; under Hd, C1 may be an unknown contributor.
+ Peak height expectation: This is the model’s expected average peak height, often written as P.H.expectation. High value = more DNA signal / taller peaks expected. This means the model expects peak heights around that scale.
+ Peak height variability: This controls how variable peak heights are around the expected value.
  + Low variability: observed peaks should be close to fitted peaks.
  + High variability: the model allows more imbalance/randomness.
+ Degradation slope: Degradation means longer fragments tend to produce lower peaks. Estimate if `Degradation:YES`
+ Stutter proportion: Stutter is an artefact peak, usually one repeat unit shorter than the true allele. Estimated if `Stutter:YES`
+ Drop-in probability：Drop-in means an extra allele appears although it does not belong to the true contributors.
+ Drop-out：Drop-out means a true allele is not observed above the detection threshold. In continuous models, drop-out is handled through the peak-height model and detection threshold: if a true allele is expected to be very low, it may fall below the detection threshold. 
  + E.g.: Detection threshold=50 -> a true peak may be modelled as unobserved if it falls below this threshold