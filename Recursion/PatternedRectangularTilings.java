public class PatternedRectangularTilings{
    //Program to create a 2xn rectangular tiling pattern with some restrictions
    //There are 3 ways to stack single cubes to meet requirements
    //There are 4 ways to stack collections of 3 blocks + 1 block to meet stipulated conditions
    //We create a recursive program to give the number of tilings of the 2xn board
    

    public static int generateNumberOfTilings(int n)//Where n is for 2 by n tilings
    {
        if(n < 0)
        {
             throw new IllegalArgumentException();
        }
        else if(n == 1)
        {
            return 3;//Base case 1, three possible tilings of individual blue and black cubes to from a 2x1 combination that does not violate requirements
        }
        else if(n == 0)
        {
            return 1;//Base case 0, for 2x0 tiling, there is only 1 solution
        }
        else
        {
            return (3 * (generateNumberOfTilings(n-1)) + 4 * (generateNumberOfTilings(n-2)));
        }
    }

    public static void main(String[] args)
    {
        for(int i=0; i<=10; i++)
        {
            System.out.println("Number of tilings for 2 x n; n = " + i + " is " + generateNumberOfTilings(i));
        }
    }
}