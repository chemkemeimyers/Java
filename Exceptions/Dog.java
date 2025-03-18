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
        try
        {
            int result;
            if(this.getDroolRate() < 3.5)
            {
                result =  (int) (this.getPainLevel()*2/this.getHealth());
            }
            else if(3.5 <= this.getDroolRate() && this.getDroolRate() <= 7.5)
            {
                result =  (int) (this.getPainLevel()/this.getHealth());
            } 
            else 
            {
                result = (int) (this.getPainLevel()/(this.getHealth() * 2));
            }
            super.heal();
            return result;
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