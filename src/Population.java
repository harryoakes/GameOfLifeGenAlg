/**
 * The population of chromosomes for my genetic algorithm
 */
public class Population {
    Chromosome[] chromosome;

    /**
     * Creates a population of chromosomes with the given size
     * @param populationSize The size of the population
     */
    public Population(int populationSize) {
        chromosome = new Chromosome[populationSize];
        for (int i = 0; i < populationSize; i++) {
            chromosome[i] = new Chromosome();
        }
    }

    public Chromosome[] getChromosomes() {
        return chromosome;
    }
}
