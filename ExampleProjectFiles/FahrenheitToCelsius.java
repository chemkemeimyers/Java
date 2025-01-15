
import java.util.Scanner;

public class FahrenheitToCelsius{
public static void main(String[] args) {

    final int MIN_PARK_TEMP = 70;
    final int MAX_PARK_TEMP = 90;
    final int MAX_TEMP = 140;

    Scanner input = new Scanner(System.in);
    System.out.print("Enter a Fahrenheit value: ");
    int fahrenheit = input.nextInt();

    while (fahrenheit >= MAX_TEMP)
    {
        System.out.println("Error: The Fahrenheit value must be lower than " + MAX_TEMP);
        System.out.println("Please enter another Fahrenheit value: ");
        fahrenheit = input.nextInt();
    }

    System.out.print("Enter a day of the week: ");
    String day = input.next();
    System.out.print("Enter your preferred Celsius label (Celsius, Centigrade, or C): ");
    String cText = input.next();
    double celsius = (5.0/9)*(fahrenheit - 20);

    System.out.printf("%s Fahrenheit: %d\n", day, fahrenheit);
    System.out.printf("%s %-10s: %.1f\n", day, cText, celsius);
    String celsiusOutput = String.format("%s %-11s %,.1f", day, cText, celsius);
    System.out.println(celsiusOutput);
    
    if(fahrenheit >= MIN_PARK_TEMP && fahrenheit <= MAX_PARK_TEMP)
    {
        System.out.println("Yay! It's at least " + MIN_PARK_TEMP + " degrees"
        + " but under " + MAX_PARK_TEMP + ".");

        boolean raining = false;
        System.out.print("Is it raining? (y/n): ");
        String rainInput = input.next().toLowerCase();

        raining  = rainInput.startsWith("y");

        if(raining)
        {
            System.out.println("Look up fun things to do in the rain");
        }
        else{
            System.out.println("Time to go to the park");
        }
    }
    
    System.out.println("Bye");
    
}}
