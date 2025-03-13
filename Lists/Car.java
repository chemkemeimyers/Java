public class Car{

    private String name;
    private String make;
    private int year;

    public Car(String name, String make, int year)
    {
        this.name = name;
        this.make = make;
        this.year = year;
    }

    public String getName()
    {
        return name;
    }

    public String getMake()
    {
        return make;
    }

    public int getYear()
    {
        return year;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setMake(String make)
    {
        this.make = make;
    }

    public void setYear(int year)
    {
        this.year = year;
    }
}