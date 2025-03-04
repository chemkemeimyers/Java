public class InsectClient{
    public static void main(String[] args) {
        System.out.println(Insect.produceRandomFacts());

        Insect bug1 = new Insect(13, 31, 0);
        System.out.println(bug1.getWeight());
        System.out.println(bug1.getX());
        bug1.setX(-314);
        System.out.println(bug1.getX());
        bug1.setX(133);
        System.out.println(bug1.getX());
        System.out.println(bug1.getY());
        System.out.println("Insect population: " + Insect.getPopulation());

        Insect bug2 = new Insect(31);
        System.out.println(bug2.getWeight());
        System.out.println(bug2.getX());
        System.out.println(bug2.getY());
        System.out.println("Insect population: " + Insect.getPopulation());

        Insect bug3  = new Insect(99);
        System.out.println(bug3.toString());
        System.out.println("Insect population: " + Insect.getPopulation());
    }
}