import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.File;
public class Wolf extends Canine implements Comparable<Wolf>
{
    protected int rank;
    public Wolf(double size, int rank)
    {
        super(size);
        this.rank = rank;
    }

    public int getRank()
    {
        return rank;
    }

    public void bark(int barkMultiple)
    {
        for(int i=1; i<=barkMultiple; i++)
        {
            super.bark();
        }
    }

    public void groom()
    {
        System.out.println("lick");
    }

    public int compareTo(Wolf anotherWolf)
    {
        return -(rank - anotherWolf.rank);
    }

    public String toString()
    {
        return ("Rank " + rank + ", Size " + size);
    }

    public void pay()
    {
        System.out.println("Grrrr! Warning, don't try and chase me for payment. I'm a wolf. Run Run Run!");
    }

    public static void main(String[] args)
    {
        Wolf[] pack = {
            new Wolf(17.1, 2),
            new Wolf(3, 10),
            new Wolf(9.2, 7),
            new Wolf(9.1, 8),
            new Wolf(17.01, 3),
            new Wolf(16.2, 1),
            new Wolf(16, 4),
            new Wolf(16, 5),
            new Wolf(10, 6),
            new Wolf(5, 9)
        };
        Arrays.sort(pack);

        File fileout = new File("SortedWolves.csv");

        PrintWriter filePrint = null;

        try{
            filePrint = new PrintWriter(fileout);
            for(Wolf wolf: pack)
            {
                filePrint.println(wolf.getRank() + "," + wolf.getSize());
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

        finally{
            if(filePrint != null)
            {
                filePrint.close();
            }
        }
        System.out.println("Unsorted Pack: " + Arrays.toString(pack));
        
        System.out.println("Sorted Pack: " + Arrays.toString(pack));
            }

}