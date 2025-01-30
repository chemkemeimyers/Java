public class Fly
{
    private double mass;
    private double speed;
    private static double DEFAULT_SPEED = 10;
    private static double DEFAULT_MASS = 5;

    public Fly(double mass)
    {
        this(mass, DEFAULT_SPEED);
    }

    public Fly()
    {
        this(DEFAULT_MASS, DEFAULT_SPEED);
    }

    public Fly(double mass, double speed)
    {
        this.mass = mass;
        this.speed = speed;
    }
    public double getMass()
    {
        return mass;
    }
    public double getSpeed()
    {
        return speed;
    }
    public void setMass(double mass)
    {
        if(mass >= 0)
            this.mass = mass;
    }
    public void setSpeed(double speed)
    {
        if(speed > 0)
            this.speed = speed;
    }
    public String toString()
    {
        if(this.isDead())
            return "I'm dead, but I used to be a fly with a speed of " +  String.format("%.2f", this.speed) + ".";
        else
            return "I'm a speedy fly with " +  String.format("%.2f", this.speed) +" speed and " +  String.format("%.2f", this.mass) +" mass.";
    }
    public void grow(int addedMass)
    {
        double originalMass = this.mass;
        this.mass = this.mass + addedMass;
        double changeInSpeed;
        if(originalMass < 20 && addedMass > 0)
        {
            changeInSpeed = this.mass > 20 ? 20 - originalMass: this.mass - originalMass;
            this.speed+=changeInSpeed;
        }
        if(this.mass > 20 && addedMass > 0)
        {
            changeInSpeed = -0.5 * (originalMass > 20? addedMass: this.mass-20);
            this.speed+=changeInSpeed;
        }
    }
    public boolean isDead()
    {
       return this.mass == 0;
    }
}