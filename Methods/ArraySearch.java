public class ArraySearch{
    public static void main (String[] args)
    {

    }
    public static boolean searchArray(String[] array, String target)
    {
        boolean result = false;
        for(String word: array)
        {
            if((word != null) && word.equals(target))
            {
                result = true;
                break;
            }
        }
        return result;
    }
    public static boolean searchArray(int[] array, int target)
    {
        boolean result = false;
        for(int num: array)
        {
            if(num == target)
            {
                result = true;
                break;
            }
        }
        return result;
    }
}