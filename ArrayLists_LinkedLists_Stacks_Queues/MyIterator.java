
import java.util.Iterator;

public class MyIterator implements Iterator<String>{

    //MyIterator class is an example of how to implement the Iterator interface
    private int index = 0;
    private String[] data = {"a", "b", "c"};

    //implement the hasNext method
    @Override
    public boolean hasNext()
    {
        return index < data.length;
    }

    //implement the next method
    @Override
    public String next()
    {
        return data[index++];
    }

    //Implement optional method remove
    @Override
    public void remove()
    {
        throw new UnsupportedOperationException();
    }
    
}
