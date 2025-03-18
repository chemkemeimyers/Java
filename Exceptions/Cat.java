

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
       int result;
        if(this.getMiceCaught() < 4)
        {
            result =  (int) Math.ceil((this.getPainLevel()*2)/this.getHealth());
        }
        else if(this.getMiceCaught() >= 4 && this.getMiceCaught() <= 7)
        {
            return (int) Math.ceil(this.getPainLevel()/this.getHealth());
        }
        else{
            return (int) Math.ceil(this.getPainLevel()/(this.getHealth()*2));
        }
        super.heal();
        return result;
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