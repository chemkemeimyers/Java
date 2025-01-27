public class Fly
{
    private double mass;
    private double speed;
    private static final double DEFAULT_SPEED = 10;
    private static final double DEFAULT_MASS = 5;

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
        if(mass > 0)
            this.mass = mass;
    }
    public void setSpeed(double speed)
    {
        if(speed > 0)
            this.speed = speed;
    }
    public String toString()
    {
        if(this.mass == 0)
            return "I’m dead, but I used to be a fly with a speed of " + this.speed + ".";
        else
            return "I’m a speedy fly with " + this.speed +" speed and " + this.mass +" mass";
    }
    public void grow(int addedMass)
    {
        double originalMass = this.mass;
        this.mass = this.mass + addedMass;
        double changeInSpeed;
        if(this.mass < 20)
            changeInSpeed = this.mass - originalMass;
        else
            changeInSpeed = -0.5 * (this.mass - 20);
        

        this.speed = this.speed + changeInSpeed;
    }
    public boolean isDead()
    {
       return this.mass == 0;
    }
}