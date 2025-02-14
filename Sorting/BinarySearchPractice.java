

public class BinarySearchPractice{
    public static int binarySearch(int[] array, int target)
    {
        int low=0, high = array.length-1;

        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(array[mid]==target)
                return mid;
            else if(array[mid] > target)
                high = mid-1;
            else 
                low = mid+1;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] arr = {2,4,7,10,14,18,22};
        int target = 10;
        int result = binarySearch(arr,target);
        
        if(result!=-1)
        {
            System.out.println("Element found at index: " + result);
        }
        else
            System.out.println("Element not found");
    }
}