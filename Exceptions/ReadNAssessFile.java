import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadNAssessFile
{
    public static double getAverage(double[] nums)
    {
        double total = 0;
        for(int i=0; i< nums.length; i++)
        {
            total = total + nums[i];
        }
        return total/nums.length;
    }

    public static void main(String[] args)
    {
        File fileIn = new File("SortedWolves.csv");

        Scanner fileScan = null;
        Scanner wolfScan = null;
        double[] allWeights = new double[10];
        int index = 0;

        try{
            fileScan = new Scanner(fileIn);
            String line = null;
            while(fileScan.hasNextLine())
            {
                line = fileScan.nextLine();
                wolfScan = new Scanner(line);
                wolfScan.useDelimiter(",");
                wolfScan.nextInt(); //consume unused rank token
                allWeights[index] = wolfScan.nextDouble();
                index++;
            }
            System.out.println("Average wolf rank is " + getAverage(allWeights));
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        finally
        {
            if(fileScan != null)
            {
                fileScan.close();
            }
        }
    }
}