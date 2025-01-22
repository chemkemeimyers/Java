public class Insect{
    private double weight;
    private int x;
    private int y;

    private final double DIST_WEIGHT_LOSS_FACTOR = 0.001;

    public Insect(double initWeight, int initX, int initY)
    {
        weight = initWeight;
        x = initX;
        y = initY;
    }
    //test method
    public static void main(String[] main)
    {
        //Insect buzz1 = new Insect();
       // Insect buzz2 = new Insect();
        Insect bug1 = new Insect(10, 100,  90);
        Insect bug2 = new Insect(4, -300,  400);
        bug1.move(1, 10);
        bug2.move(-300, 400);
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
}