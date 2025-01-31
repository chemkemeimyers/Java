public class GroomEverything{
    public static void main(String[] args)
    {
        Canine[] groomer = {
            new Wolf(17.01, 3),
            new Poodle("richie", 9, "Lux Brand", "Rich Brand"),
            new Wolf(16, 5),
            new Poodle("play", 4, "Top Shelf", "Only the best")
        };

        for(Canine c: groomer)
        {
            c.groom();
        }
    }
}