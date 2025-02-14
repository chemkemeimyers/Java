public class LinearSearchPractice{
    public static int LinearSearch(int[] array, int target)
    {
        for(int i=0; i< array.length; i++)
        {
            if(target == array[i])
                return i;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] array = {0,1,2,3,4,5,6};
        int target = 10;

        int result = LinearSearch(array,target);

        if(result !=-1)
            System.out.println("Target value " + target + " was found at index " + result);
        else
            System.out.println("Target value " + target + " was not found in array");
    }
}