

public class Person implements Comparable<Person>{

    //Class for object person that implements the comparable interface
    //Define private variables
    private String name;
    private int age;    

    //Define the constructor
    public Person(String name, int age)
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

    //override the compareTo method
    public int compareTo(Person otherPerson)
    {
        return this.age - otherPerson.getAge();
    }

    //Define the main method
    public static void main(String[] args) 
    {
        Person person1 = new Person("Ivan", 20);
        Person person2 = new Person("Mary", 30);
        if(person1.compareTo(person2) > 0)
        {
            System.out.println(person1.getName() + " is older than " + person2.getName());
        }
        else if(person1.compareTo(person2) < 0)
        {
            System.out.println(person2.getName() + " is older than " + person1.getName());
        }
        else{
            System.out.println(person1.getName() + " is the same age as " + person2.getName());
        }
    }
    
}
