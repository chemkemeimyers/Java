// Generic container class with a private object property
public class ContainerObject {

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
 
}
