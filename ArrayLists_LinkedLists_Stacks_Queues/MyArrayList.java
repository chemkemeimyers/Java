import java.util.Arrays;
import java.util.ArrayList;

public class MyArrayList<T>{
    private Object[] backingArray;
    private int size = 0;
    private static final int INITIAL_CAPACITY = 10;

    public MyArrayList(){
        backingArray = new Object[INITIAL_CAPACITY];
    }


    //Check for space for a new element
    private void CapacityPresentForNewElement()
    {
        if (size == backingArray.length)
        {
            backingArray = Arrays.copyOf(backingArray, backingArray.length * 2);
        }
    }

    //Add element at end
    public void add(T element)
    {
        CapacityPresentForNewElement();
        backingArray[size] = element;
        size++;
    }

    private void checkBounds(int index)
    {
        if(index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds."); 
        }
    }

    //Get element at index
    @SuppressWarnings("unchecked")
    public T get(int index){
        checkBounds(index);
        return (T) backingArray[index];
    }

    //Remove element at index
    @SuppressWarnings("unchecked")
    public T remove(int index)
    {
        checkBounds(index);

        T removed = (T) backingArray[index];

        //Shift elements left
        for(int i = index; i< size-1; i++)
        {
            backingArray[i] = backingArray[i+1];
        }

        backingArray[size-1]=null;
        size--;

        return removed;
    }

    @SuppressWarnings("unchecked")
    public T remove()
    {
       if (size == 0)
       {
        throw new IllegalStateException("List is empty");
       }
    
        size--;
        T element = (T) backingArray[size];
        backingArray[size] = null;
        return element;
    }

    public int size()
    {
        return size;
    }

    //for printing
    @Override
    public String toString()
    {
        return Arrays.toString(Arrays.copyOf(backingArray, size));
    }

        public static void main(String[] args)
    {
        MyArrayList<Integer> list  = new MyArrayList<>();

        list.add(1);
        list.add(2);
        list.add(5);
        list.add(6);

        System.out.println(list);

        System.out.println("Call Remove on list...");
        list.remove();
        System.out.println(list);

        System.out.println("Call Remove on 1 list...");
        list.remove(1);
        System.out.println(list);


    }
}

