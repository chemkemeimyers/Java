public class ContainerObject {
    // Generic container class with a private object property

    //Private object property
    private Object object;

    //public method to set the object property
    public void set(Object object)
    {
        this.object = object;
    }

    //Public method to get the object property
    public Object get()
    {
        return this.object;
    }

    public static void main(String[] args) {
        ContainerObject c1 = new ContainerObject();
        c1.set("hello");
        String s = (String)c1.get();
        System.out.println("The object has value: " + s);

    }
 
}
