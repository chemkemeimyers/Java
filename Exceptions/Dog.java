public class Dog extends Pet{
    protected double droolRate;

    public Dog(String name, double health, int painLevel, double droolRate)
    {
        super(name, health, painLevel);
        if(droolRate <= 0)
            this.droolRate = 0.5;
        else 
            this.droolRate = droolRate;
    }

    public Dog(String name, double health, int painLevel)
    {
        super(name, health, painLevel);
        this.droolRate = 5.0;
    }

    public double getDroolRate()
    {
        return this.droolRate;
    }

    @Override
    public int treat()
    {
        double origDroolRate = this.getDroolRate();
        int origPainLevel = this.getPainLevel();
        double origHealth = this.getHealth();

        super.heal();
        try
        {
            if(origDroolRate < 3.5)
            {
                return (int) (origPainLevel*2/origHealth);
            }
            else if(3.5 <= origDroolRate && origDroolRate <= 7.5)
            {
                return (int) (origPainLevel/origHealth);
            } 
            else 
            {
                return (int) (origPainLevel/(origHealth * 2));
            }
        }
        catch(ArithmeticException e)
        {
            throw new ArithmeticException("Health is zero, causing a divide by zero exception");
        }
    }

    @Override
    public void speak()
    {
        super.speak();
        String message = "";
        for(int i=0; i< painLevel; i++)
        {
            message=message+"bark";
            if(i<painLevel-1)
                message=message+" ";
        }
        if(this.painLevel > 5)
            System.out.println(message.toUpperCase());
        else
            System.out.println(message);
    }

    @Override
    public boolean equals(Object o)
    {
        Dog toCompare = (Dog)o;
        return super.equals(o) && toCompare.getDroolRate() == this.droolRate; 
    }
}