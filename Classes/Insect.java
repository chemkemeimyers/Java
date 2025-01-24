

public class Insect{
    private double weight;
    private int x;
    private int y;

    public static final int DEFAULT_X = 0;
    public static final int DEFAULT_Y = 0;
    private final double DIST_WEIGHT_LOSS_FACTOR = 0.001;
    private static int population = 0;
    private static final String[] FACTS = {
        "The two main groups of insects are winged and wingless",
        "There are more than 1 million insect species",
        "Insects are cold-blooded",
        "Spiders are not considered insects"
    };
    //Constructors
    public Insect(double initWeight)
    {
        this(initWeight, DEFAULT_X, DEFAULT_Y);
    }
    public Insect(double initWeight, int initX, int initY)
    {
        weight = initWeight;
        x = initX;
        y = initY;
        population+=1;
    }

    //test method
    public static void main(String[] main)
    {
        //Insect buzz1 = new Insect();
       // Insect buzz2 = new Insect();
        System.out.println("Insect Population: " + population);
        Insect bug1 = new Insect(10, 100,  90);
        System.out.println("Insect Population: " + population);
        Insect bug2 = new Insect(4, -300,  400);
        System.out.println("Insect Population: " + population);
        bug1.move(1, 10);
        bug2.move(-300, 400);
        System.out.println(produceRandomFacts());
    }

    //methods
    public void eat(double amount){
        System.out.println("Nibble Nibble");
        weight = weight + amount;
    }

    public void move(int newX, int newY)
    {
        double distance = calculateDistance(x, y, newX, newY);
        if(distance > 0)
        {
            x = newX;
            y = newY;
            weight = weight * DIST_WEIGHT_LOSS_FACTOR * distance;
            System.out.printf("Moved %.2f units\n", distance);
        }
        else
        {
            System.out.println("Staying put");
        }
    }

    private static double calculateDistance(double x1, double y1, double x2, double y2)
    {
        return Math.sqrt((y2-y1)*(y2-y1) + (x2-x1)*(x2-x1));
    }

    public static String produceRandomFacts()
    {
        int index = (int)(Math.random() * ((FACTS.length - 1) + 1));
        return FACTS[index];
    }
    public double getWeight()
    {
        return weight;
    }
    public int getX()
    {
        return x;
    }
    public void setX(int newX)
    {
        if(isLegalNewX(newX))
            x = newX;
    }
    public int getY()
    {
        return y;
    }
    public void setY(int newY)
    {
        if(isLegalNewX(newY))
            y = newY;
    }
    public static int getPopulation()
    {
        return population;
    }
    public static boolean isLegalNewX(int newX)
    {
        return newX >= 0;
    }
    public static boolean isLegalNewY(int newY)
    {
        return newY >= 0;
    }
}