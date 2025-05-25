public class PersonTest{

    //Class for object person that implements the comparable interface
    //Define private variables
    private String name;
    private int age;    

    //Define the constructor
    public PersonTest(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    //Define getters for name and age
    public String getName()
    {
        return this.name;
    }

    public int getAge()
    {
        return this.age;
    }
}