
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        {
            PersonTest person1 = new PersonTest("Miguel", 31);

            PersonTest person2 = new PersonTest("Ivan", 43);

            PersonTest person3 = new PersonTest("Adrianna", 15);

            PersonTest person4 = new PersonTest("Mary", 26);

            PersonTest person5 = new PersonTest("Andrew", 7);

            List<PersonTest> PersonList = new ArrayList<>();

            //Create a list of persons
            PersonList.addAll(List.of(person1, person2, person3, person4, person5));

            System.out.println("Original: ");
            for(PersonTest p: PersonList)
            {
                System.out.println(p.getName());
            }

            //Sort the list with the comparator interface
            Collections.sort(PersonList, new PersonComparator());

            System.out.println("SortedList: ");
            for(PersonTest p: PersonList)
            {
                System.out.println(p.getName());
            }



        }
    }
    
}
