public class Population {
    Chromosome[] chromosome;

    public Population(int populationSize) {
        chromosome = new Chromosome[populationSize];
        for (int i = 0; i < populationSize; i++) {
            chromosome[i] = new Chromosome();
        }
    }
}
