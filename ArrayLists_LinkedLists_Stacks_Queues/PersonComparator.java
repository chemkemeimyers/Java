import java.util.Comparator;

//Class to implement Comparator interface. Provides method to compare PersonTest objects
public class PersonComparator implements Comparator<PersonTest> {
    @Override
    public int compare(PersonTest personOne, PersonTest personTwo)
    {
        return personOne.getName().length() - personTwo.getName().length();
    }
}
