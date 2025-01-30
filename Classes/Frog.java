public class Frog
{
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;
    private String species;
    private static String DEFAULT_SPECIES = "Rare Pepe";
    private static int DEFAULT_AGE = 5;
    private static double DEFAULT_TONGUESPEED = 5;

    public Frog(String name, int age, double tongueSpeed)
    {
        this.name = name;
        this.age = age;
        this.tongueSpeed = tongueSpeed;
        this.isFroglet = age > 1 && age < 7;
        this.species = DEFAULT_SPECIES;
    }
    public Frog(String name, double ageInYears, double tongueSpeed)
    {
        this(name,(int) (ageInYears * 12),tongueSpeed);
    }
    public Frog(String name)
    {
        this(name, DEFAULT_AGE, DEFAULT_TONGUESPEED);
    }
    public void grow(int numMonths)
    {
        int originalAge = this.age;
        this.age = this.age + numMonths;

        double changeInSpeed; 
        if((12-originalAge) > 0)
        {
            this.tongueSpeed = this.tongueSpeed + (12-originalAge);
        }
        if(this.age>=30)
        {
            changeInSpeed= this.age - 30;
            this.tongueSpeed = (this.tongueSpeed - changeInSpeed) < 5 ? 5: (this.tongueSpeed - changeInSpeed);
        }

         this.isFroglet = age > 1 && age < 7;
    }
    public void grow()
    {
        int originalAge = this.age;
        this.age+=1;
        double changeInSpeed; 
        if(this.age<=12)
        {
            changeInSpeed= this.age <= 12 ? this.age - originalAge : 12 - originalAge;
            this.tongueSpeed = this.tongueSpeed + changeInSpeed;
        }
        if(this.age>=30)
        {
            changeInSpeed= this.age - 30;
            this.tongueSpeed = (this.tongueSpeed - changeInSpeed) < 5 ? 5: (this.tongueSpeed - changeInSpeed);
        }

         this.isFroglet = age > 1 && age < 7;

    }
    public void eat(Fly food)
    {
        if(food.isDead()) 
        {
        }
        else
        {
            if(this.tongueSpeed > food.getSpeed())
            {
                //The fly is caught
                food.setMass(0);
                if(food.getMass() >= 0.5 * this.age)
                {
                    this.grow();
                }
            }
            else
            {
                //fly is NOT caught
                food.grow(1);
            }
        }
    }
    public String toString()
    {
        String resultString;
        if(this.isFroglet)
            resultString = "My name is " + this.name + " and I'm a rare froglet! I'm " +  this.age +" months old and my tongue has a speed of " + String.format("%.2f", this.tongueSpeed)+".";
        else
            resultString = "My name is " + this.name + " and I'm a rare frog. I'm " + this.age +" months old and my tongue has a speed of " + String.format("%.2f", this.tongueSpeed) + ".";
        return resultString;
    }
    public String getName()
    {
        return this.name;
    }
    public int getAge()
    {
        return this.age;
    }
    public double getTongueSpeed()
    {
        return tongueSpeed;
    }
    public boolean getIsFroglet()
    {
        return isFroglet;
    }
    public String getSpecies()
    {
        return species;
    }
    public static void setSpecies(String speciesName)
    {
        DEFAULT_SPECIES = speciesName;
    }
}