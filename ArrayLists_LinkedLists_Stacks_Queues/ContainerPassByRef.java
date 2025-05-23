public class ContainerPassByRef {

    //Private int property of class ContainerPassByRef
    private int item;

    //Constructor for class ContainerPassByRef which takes an integer
    public ContainerPassByRef(int item)
    {
        this.item = item;
    }

    //Public method to set the value of item
    public void setItem(int item)
    {
        this.item = item;
    }

    //Public method to get the value of item
    public int getItem()
    {
        return item;
    }
    
    //Method to take a ContainerPassByRef object and increment its value by 1
    public static void helper(ContainerPassByRef x)
    {
        x.setItem(x.getItem() + 1);//Modify the original item
    }

    //Main method to create a ContainerPassByRef object, call the helper method and print the value of the object after the helper method executes
    public static void main(String[] args) {
        ContainerPassByRef count = new ContainerPassByRef(0);
        helper(count);
        System.out.println(count.getItem());
    }
}
