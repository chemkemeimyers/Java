public class InsertionSortComparable{
    

    public static void InsertionSort(Comparable[] list)
    {
        for(int unSortedStart = 1; unSortedStart < list.length; unSortedStart++)
        {
            Comparable nextInsert = list[unSortedStart];
            int currentIndex = unSortedStart - 1;

            while(currentIndex >= 0 && list[currentIndex].compareTo(nextInsert)>0)
            {
                list[currentIndex+1] = list[currentIndex];
                currentIndex--;
            }
            list[currentIndex+1] = nextInsert;
        }
    }

}