public class Point {
    private double x;
    private double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    //Constructor chaining
    public Point(double a)
    {
        this(a, 0);
    }
}
