public class Main {

    public static void main(String[] args) {
        GeneticAlgorithm ga = new GeneticAlgorithm(100,5,5);
        Chromosome best = ga.run(100);
        System.out.println("Best Chromosome:");
        System.out.println(best);
    }
}
