public class ArraysKnowledgeCheck{
    public static void main(String[] args)
    {
        int[] threes = {3, 6, -3, -6};
        System.out.println("Last element in array is " + threes[threes.length-1]);

        int i = 0;
        while(i < threes.length)
        {
            threes[i] = threes[i]*3;
            i++;
        }
        for(int j = 0; j < threes.length; j++)
            System.out.println("Array element j is " + threes[j]);

        boolean x = true;
        int count = 0;
        while(x)
        {
            count +=3;
            if(count %5 == 0)
            {
                x = false;
            }
        }
        System.out.println(count);

        for (int k = 0; k < 10; k++) 
        {
            for(int j = 15; j < 0; j-=2)
            {
                System.out.println("k,j: " + k + "," + j);
                System.out.print(k*j);
            }
        }


    }
}