
import java.util.Random;


public class LinearSearchAlgorithm{

    public static int linearSearch(Comparable target, Comparable[] list)
    {
       int index = 0;
       while(index < list.length)
       {
        if(list[index].compareTo(target) == 0)
            return index;
        else
            index+=1;
       }
       return -1;
    }
    public static void main(String[] args) {
        
    
    Integer[] numbers  = new Integer[1000000];
    Random rand = new Random();
    for (int i=0; i<numbers.length; i++)
    {
        numbers[i] = rand.nextInt(1000000);
    }
    Integer target = 1432;
    System.out.println("Number " + target + " is " + (linearSearch(target, numbers) > 0? "present ": "absent ") + "in random array with " + numbers.length + " elements");
    }

}