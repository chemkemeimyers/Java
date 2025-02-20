import java.util.InputMismatchException;
import java.util.Scanner;
public class FarenheitToCelsiusException{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        boolean success = false;
        int fahrenheit = 0;
        while(!success)
        {
            try 
            {
                System.out.print("Enter a Fahrenheit value:");
                fahrenheit = input.nextInt();
                success = true;
                
            } 
            catch (InputMismatchException e) 
            {
                input.nextLine();
                System.out.println("Sorry, that wasn't an int");
                System.out.println("Please try again");
            }
        }
        double celsius = (5.0/9)*(fahrenheit-32);
        System.out.printf("Fahrenheit: %d\n", fahrenheit);
        System.out.printf("Celcius: %.1f\n",celsius);
    }
}