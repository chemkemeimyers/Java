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

    public static void main(String[] args) {

        ContainerGenerics<String> c1 = new ContainerGenerics<String>();
        c1.set("Hello!");
        String s = c1.get();
    }
}
