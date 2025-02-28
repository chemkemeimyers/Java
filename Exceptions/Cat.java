public class Cat extends Pet{
    protected int miceCaught;

    public Cat(String name, double health, int painLevel, int miceCaught)
    {
        super(name, health, painLevel);
        if(miceCaught < 0)
            this.miceCaught = 0;
        else
            this.miceCaught = miceCaught;
    }

    public Cat(String name, double health, int painLevel)
    {
        super(name, health, painLevel);
        this.miceCaught = 0;
    }

    public int getMiceCaught()
    {
        return this.miceCaught;
    }

    @Override
    public int treat()
    {
        super.heal();
        if(miceCaught < 4)
        {
            return (int) Math.ceil((painLevel*2)/health);
        }
        else if(miceCaught >= 4 && miceCaught <= 7)
        {
            return (int) Math.ceil(painLevel/health);
        }
        else{
            return (int) Math.ceil(painLevel/(health*2));
        }
    }

    @Override
    public void speak()
    {
        super.speak();
        String message = "";
        for(int i=0; i<miceCaught; i++)
        {
            message+="meow";
            if(i<miceCaught-1)
                message+= " ";
        }
        if(painLevel > 5)
            System.out.println(message.toUpperCase());
        else
            System.out.println(message);
    }

    @Override
    public boolean equals(Object o)
    {
        Cat toCompare = (Cat) o;
        return super.equals(o) && toCompare.miceCaught == this.miceCaught; 
    }
}