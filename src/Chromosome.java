/**
 * The Chromosome is an individual in my genetic algorithms population
 */
public class Chromosome {
    private boolean[][] genes;
    private double fitness;

    /**
     * Creates the random genes and sets the fitness to 0
     */
    public Chromosome(int width, int height) {
        fitness = 0;
        genes = new boolean[width][height];
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                genes[i][j] = Math.random() < 0.5;
            }
        }
    }

    /**
     * Creates a chromosome with the given genes and sets the fitness to 0
     * @param genes The genes of the chromosome
     */
    public Chromosome(boolean[][] genes) {
        this.genes = genes;
        fitness = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fitness: ").append(fitness).append("\nGenes:\n");
        for (boolean[] row : genes) {
            for (boolean gene : row) {
                sb.append(gene ? "1" : "0");
            }
            sb.append("\n");
        }
        return sb.toString();
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
