public class FindMax {

    /**
     * This method should return the largest number in the passed in array.
     * 
     * Constraints:
     * 1 <= nums.length <= 100
     * -10000 <= nums[i] <= 10000
     * 
     * @param nums An array containing integers.
     * @return The largest number in nums.
     */
    
    public static int findMax(int[] nums) {
        int maxValue = Integer.MIN_VALUE;
        
          for(int i = 0; i < nums.length; i++)
          {
              if(maxValue < nums[i])
              {
                  maxValue = nums[i];
              }
          }
           
        return maxValue;
    }

    public static void main(String[] args)
    {
        int[] thisArray = {-65, -251, -1252, -7, -640, -4820};
        int maxValue = findMax(thisArray);
        System.out.println("The largest value in this array is: " + maxValue);
    }
}
