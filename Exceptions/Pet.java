public abstract class Pet{
    protected String name;
    protected double health;
    protected int painLevel;
    public Pet(String name, double health, int painLevel)
    {
        this.name = name;

        if(health > 1.0)
            this.health = 1.0;
        else if(health < 0.0)
            this.health = 0.0;
        else
            this.health = health;

        if(painLevel > 10)
            this.painLevel = 10;
        else if(painLevel < 1)
            this.painLevel = 1;
        else 
            this.painLevel = painLevel;
            
    }

    public String getName()
    {
        return this.name;
    }

    public double getHealth()
    { 
        return this.health;
    }

    public int getPainLevel()
    {
        return this.painLevel;
    }

    public abstract int treat();

    public void speak()
    {
        String message = "Hello! My name is " + this.name;
        if(painLevel > 5)
            System.out.println(message.toUpperCase());
        else
            System.out.println(message);
    }

    public boolean equals(Object o)
    {
        Pet toCompare = (Pet)o;
        return toCompare.name.equals(this.name);
    }

    protected void heal()
    {
        this.health = 1.0;
        this.painLevel = 1;
    }
}