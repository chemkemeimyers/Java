public class ContainerGenerics<T> {
    //A generic container class
    private T t;

    //Public method to set the value of private property t
    public void set(T t)
    {
        this.t = t;
    }

    //Public method to get the value of private property t
    public T get()
    {
        return t;
    }

    
}
