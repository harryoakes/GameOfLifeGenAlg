public class GeneticAlgorithm {
    private Population population;

    public GeneticAlgorithm(int populationSize) {
        population = new Population(populationSize);
    }

    public Chromosome run(int iterations) {
        for (int i = 0; i < iterations; i++) {
            for (Chromosome c : population.getChromosomes()) {
                //eval
            }
            //selection
            //crossover
            //mutation
        }
        //return best chromosome
        return null;
    }
}
