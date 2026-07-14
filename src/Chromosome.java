/**
 * The Chromosome is an individual in my genetic algorithms population
 */
public class Chromosome {
    private boolean[][] genes;
    private double fitness;

    /**
     * Creates the random genes and sets the fitness to 0
     */
    public Chromosome() {
        fitness = 0;
        for(int i = 0; i < genes.length; i++) {
            for(int j = 0; j < genes[i].length; j++) {
                genes[i][j] = Math.random() < 0.5;
            }
        }
    }

    public boolean[][] getGenes() {
        return genes;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }
}
