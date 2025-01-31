public class Wolf extends Canine {
    protected int rank;

    public Wolf(double size, int rank)
    {
        super(size);
        this.rank = rank;
    }

    public int getRanck()
    {
        return rank;
    }
    public void bark(int barkMultiple)
    {
        for(int i = 1; i<= barkMultiple; i++)
        {
            super.bark();
        }
    }
    public void groom()
    {
        System.out.println("lick");
    }
}