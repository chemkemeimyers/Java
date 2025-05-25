

public class MenuItem implements  Comparable<MenuItem> {
    //Menu item class that implements the comparable interface

    //Declare private class variables
    private String name;
    private int price;

    //Create constructor
    public MenuItem(String name, int price)
    {
        this.name = name;
        this.price = price;
    }
    
    //Define compareTo method
    public int compareTo(MenuItem otherItem)
    {
        return this.price - otherItem.price;
    }

    //Define getter method for name
    public String getName()
    {
        return this.name;
    }

    //Define getter for price
    public int getPrice()
    {
        return this.price;
    }

    //Create the main method to execute the code
    public static void main(String[] args)
    {
        MenuItem item1 = new MenuItem("cheesesteak", 4);
        MenuItem item2 = new MenuItem("cheesecake", 7);

        if(item1.compareTo(item2) < 0)
        {
            System.out.println(item2.getName() + " costs more than " + item1.getName());
        }
        else if(item1.compareTo(item2) > 0)
        {
            System.out.println(item1.getName() + " costs more than " + item2.getName());
        }
        else
        {
            System.out.println(item1.getName() + " costs the same as " + item2.getName());
        }
    }
}
