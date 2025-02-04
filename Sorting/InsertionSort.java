
public class InsertionSort{
    public static void InsertionSort(int[] list)
    {
        for(int unSortedStart = 1; unSortedStart < list.length; unSortedStart++)
        {
            int nextInsert = list[unSortedStart];
            int currentIndex = unSortedStart - 1;

            while(currentIndex >= 0 && list[currentIndex] > nextInsert)
            {
                list[currentIndex+1] = list[currentIndex];
                currentIndex--;
            }
            list[currentIndex+1] = nextInsert;
        }
    }
}