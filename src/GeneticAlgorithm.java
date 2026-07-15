public class GeneticAlgorithm {
    private Population population;

    public GeneticAlgorithm(int populationSize) {
        population = new Population(populationSize);
    }

    public Chromosome run(int iterations) {
        for (int i = 0; i < iterations; i++) {
            for (Chromosome c : population.getChromosomes()) {
                evaluateFitnessSimple(c,100);
            }
            //selection
            //crossover
            //mutation
        }
        //return best chromosome
        return null;
    }

    private void evaluateFitnessSimple(Chromosome c, int steps) {
        World world = new World(50, 50);
        world.initialiseWorld(c.getGenes());
        int[] numAlive = new int[steps + 1];
        numAlive[0] = world.countAliveCells();
        for (int i = 1; i < steps + 1; i++) {
            world.timeStep();
            numAlive[i] = world.countAliveCells();
        }
        double averageAlive = 0;
        for (int i = 0; i < numAlive.length; i++) {
            averageAlive += numAlive[i];
        }
        averageAlive /= numAlive.length;
        double fitness = Math.abs(averageAlive - numAlive[0]);
        c.setFitness(fitness);
    }
}
