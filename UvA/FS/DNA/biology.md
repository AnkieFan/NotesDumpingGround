+ Homozygous: AA/aa, Heterozygous: Aa

### What information is in the STR name?
+ `FSDNA 2526 the genetic basis for DNA Typing.pptx`
+ D16S539: D: DNA, 16=chromosome 16, S=single-copy sequence, 539=539th locus described on chromosome 16
+ The locus in a gene region start with a gene name abbreviation
  + TH01: Tyrosine Hydroxylase gene, intron 01
  + vWA: von Willebrand factor gene region
  + FGA: fibrinogen alpha chain gene region
  + CSF1PO: colony stimulating factor 1 receptor region
+ D8S1179:13,16 meas:
  + 13 repeats on one chromosome
  + 16 repeats on the other chromosome

### nucleotide, polymorphism
+ nucleotide: A-T, C-G
+ polymorphism:
  + sequence polymorphism/Single Nucleotide polymorphism (SNP) 单个点位
  + Length polymorphism: STRs, e.g.: Person 1: AGAT×10
  + Insertion/deletion polymorphism: A piece of DNA is inserted or deleted.

### repeat structure of this sequence:
$[TCTA]_{11}$

### 只有一条序列 可以用吗：
Sequence from only one chromosome is shown, so we know only one allele (11) of the person at this locus -> the genotype of this person is 11,Q (where Q could be any allele). We could use it for comparison, but with less power of exclusion and reduced evidential value in case of a non-exclusion.

### PBS mutation:
+ Primer binding site / PBS: The DNA sequence where the PCR primer binds.
+ Primer: A short DNA sequence used to start PCR amplification. STR kits use a forward and reverse primer.
+ Forward primer / reverse primer: The two primers flanking the STR region. Together they define the amplicon.
+ Annealing / hybridization: The step where the primer binds to the template DNA. If the PBS has a mutation, annealing may be inefficient.
+ Amplicon: The PCR product: the DNA fragment copied between the two primers.
+ Flanking region: DNA next to the STR repeat. Primers usually bind in the flanking regions, not inside the repeat itself.
+ STR region: The repeated sequence
+ SNP / SNV: A one-base sequence variant. A PBS mutation is often this type of variant
+ Null allele: An allele that is present in the genome but not detected because it failed to amplify.
+ Allele drop-out: A true allele is missing from the EPG. PBS mutation can cause allele drop-out, but drop-out can also occur stochastically in low-template DNA.
+ Allele imbalance / heterozygote imbalance: One allele peak is much lower than the other in a heterozygote. PBS mutation can cause this if one allele amplifies inefficiently.
+ Kit-specific effect: PBS mutations are often STR-kit specific because different kits use different primer sequences and primer positions. Your slides explicitly state that PBS mutations are kit specific and give D18S51 as an example where one kit’s reverse primer spans a G/A mutation, causing amplification failure and a null allele.
+ Degenerate primers: Primers designed to tolerate known variants at a primer binding site. Newer STR kits may use these to reduce PBS mutation problems
+ Concordance study: A study comparing results from different STR kits. (Does the new kit produce the same genotypes as established kits?) Important because PBS mutations can cause one kit to call an allele while another kit misses it.

### Why lowering of the PCR annealing temperature may account for the different results for locus
A PBS mutation can prevent efficient primer annealing, causing allele drop-out or a null allele. In EPG A, one D8S1179 allele is not detected because the primer does not bind well at the standard annealing temperature. When the annealing temperature is lowered in EPG B, primer binding becomes less stringent, so the mismatched primer can anneal and the previously missing allele is recovered. Therefore B reveals the true heterozygous genotype at D8S1179.

### improve the genotyping of persons carrying this PBS mutation?
1. redesign the primers: use a different reverse primer that avoids this PBS mutation (other sequence)
2. use degenerate primers: use/add the original reverse primer with a one nucleotide substitution that complements the PBS mutation
   + A degenerate primer contains mixed/alternative bases at the variable position, so it can bind both sequence versions. 


### An allelic ladder: 
+ Should be amplified with the same PCR kit as the case DNA samples
  + The allelic ladder must correspond to the same STR kit/primer system as the samples. Different kits can use different primer positions, so the fragment sizes may shift slightly. You compare sample peaks with the ladder from the same kit.
+ Is added to every DNA sample — Wrong
  + That describes the internal size standard, not the allelic ladder.
  + The internal size standard is added to every sample so the software can size fragments in base pairs. The allelic ladder is run separately as a reference sample.
+ Is used to determine the length in base pairs of a PCR-amplified DNA fragment — Wrong
  + This is mainly the role of the internal size standard.
  + internal size standard→fragment size in bp, allelic ladder→allele name, e.g. 14 or 16
+ Is detected with one fluorescent dye — Wrong
  + In multiplex STR kits, different loci are labelled with different fluorescent dyes. The allelic ladder contains alleles across multiple loci, so it uses the same dye channels as the kit, not only one dye.
+ Can be produced based on a mixture of DNA from multiple persons
  + An allelic ladder needs to contain many allele variants at many loci. It can be made by combining DNA/PCR products from different sources so that many known alleles are represented.
  + this does not mean the ladder is interpreted as a biological mixture. It is a controlled reference material.
+ Is sufficient to calibrate the STR DNA analysis — Wrong
  + Also need internal size standard

### Stutters:
+ Are the result of a germline生殖的 mutation — Wrong
  + A stutter peak is not a true inherited allele. It is a PCR artefact, usually caused by polymerase slippage during amplification of an STR repeat.
  + A germline mutation would be a real biological change inherited through sperm/egg and present in the person’s DNA. Stutter is produced during the laboratory PCR process.
+ Are artefacts caused by capillary electrophoresis — Wrong
  + Stutter is mainly a PCR artefact, not a CE artefact.
  + CE only separates and detects the amplified fragments. The stutter product already exists before CE, because it was generated during PCR.
+ May be increased, higher peaks, in LCN analysis
  + LCN analysis often uses increased PCR cycle numbers. More cycles and low-template conditions can increase stochastic effects and may make artefact peaks, including stutter, more prominent. The lecture notes describe LCN as using an elevated number of PCR cycles and note that enhanced methods produce more complex results and stochastic effects.
+ Are usually one base pair shorter than the highest peak next to it — Wrong
  + For forensic STRs, stutter is usually one repeat unit shorter, not one base pair shorter.
  + e.g.: repeat length = 4, backward stutter:n-4bp, in allele notation 16 -> 15
+ The stutter ratio may differ from locus to locus
  + Different STR loci have different repeat structures and stutter tendencies. Therefore the stutter ratio is locus-dependent. It may also vary with allele length: longer repeat arrays often have more stutter.
+ Are filtered out during analysis of a DNA reference profile
  + In a good-quality single-source reference profile, stutter peaks are normally recognized as artefacts and are not reported as true alleles. Software/lab interpretation rules use stutter filters or stutter thresholds to avoid calling them as real alleles.

### Y-STRs:
+ Y-STRs are linked
  + Y-STRs are on the Y chromosome and are inherited together as a Y haplotype. They are not treated as independent autosomal loci. The slide defines linked markers as markers that are physically close/on the same chromosome and are not passed independently.
+ If two men have the same Y-STR DNA profile, they must be from the same male lineage
  + Too strong. A matching Y-STR profile is consistent with the same paternal lineage, but it does not prove it. Two unrelated men may share the same Y-STR haplotype by chance, especially in a local population or when the profile has limited discrimination.
+ The frequency of a Y-STR DNA profile can be calculated by multiplication of the frequencies of all observed Y STRs — Wrong
  + This is the autosomal STR style of thinking under independence. For Y-STRs, the loci are linked and inherited together, so you do not multiply single-locus allele frequencies.
  + Instead, Y-STR evidential weight is usually based on the haplotype frequency in a Y-reference database such as YHRD, with appropriate population/geographical caution.
+ A Y-STR DNA profile never observed in YHRD could still occur quite frequently in a limited geographic region
  + Y-STRs follow paternal lineages, and paternal lineages can be geographically clustered. So absence from a database does not mean the haplotype is impossible or extremely rare everywhere.
+ A large proportion of sperm cells does not have a Y-STR profile
  + Sperm cells are haploid gametes. Roughly half carry an X chromosome and roughly half carry a Y chromosome. The X-bearing sperm cells do not contain a Y chromosome, so they do not have a Y-STR profile. Meiosis is producing haploid germ cells and distinguish XY males from XX females.
+ The amount of female DNA in a mixed female/male DNA sample has almost no effect on Y-STR analysis
  + Y-STR analysis targets male-specific Y-chromosomal markers. So female autosomal DNA usually does not contribute Y-STR alleles. This is why Y-STR testing is useful in male/female mixtures, especially sexual assault-type samples.
  + 