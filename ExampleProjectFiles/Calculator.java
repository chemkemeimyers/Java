
import java.util.Scanner;

public class Calculator{
    public static void main(String[] args) {
        {
            System.out.println("List of operations: add subtract multiply divide alphabetize");
            System.out.println("Enter an operation:");
            
            Scanner input = new Scanner(System.in);

            String operation;

            operation = (String)input.next().toLowerCase();

            switch(operation){
                case "add":
                    System.out.println("Enter two integers:");
                    int addNum1;
                    int addNum2;
                    if(input.hasNextInt())
                    {
                        addNum1 = input.nextInt();
                    }
                    else
                    {
                        System.out.println("Invalid input entered. Terminating...");
                        break;
                    }
                    if(input.hasNextInt())
                    {
                        addNum2 = input.nextInt();
                    }
                    else
                    {
                        System.out.println("Invalid input entered. Terminating...");
                        break;
                    }
                    System.out.println("Answer: " + (addNum1 + addNum2));
                    break;
                case "subtract":
                    System.out.println("Enter two integers:");
                    int subNum1;
                    int subNum2;
                   if(input.hasNextInt())
                    {
                        subNum1 = input.nextInt();
                    }
                    else
                    {
                        System.out.println("Invalid input entered. Terminating...");
                        break;
                    }
                    if(input.hasNextInt())
                    {
                        subNum2 = input.nextInt();
                    }
                    else
                    {
                        System.out.println("Invalid input entered. Terminating...");
                        break;
                    }
                    System.out.println("Answer: " + (subNum1 - subNum2));
                    break;
                case "multiply":
                    System.out.println("Enter two doubles:");
                    double multiplyNum1;
                    double multiplyNum2;
                    if(input.hasNextDouble())
                    {
                        multiplyNum1 = input.nextDouble();
                    }
                    else
                    {
                        System.out.println("Invalid input entered. Terminating...");
                        break;
                    }
                      if(input.hasNextDouble())
                    {
                        multiplyNum2 = input.nextDouble();
                    }
                    else
                    {
                        System.out.println("Invalid input entered. Terminating...");
                        break;
                    }
                    System.out.printf("Answer: %.2f%n", (multiplyNum1 * multiplyNum2));
                    break;
                case "divide":
                    System.out.println("Enter two doubles:");
                    double divideNum1;
                    double divideNum2;
                    if(input.hasNextDouble())
                    {
                        divideNum1 = input.nextDouble();
                    }
                    else
                    {
                        System.out.println("Invalid input entered. Terminating...");
                        break;
                    }
                    if(input.hasNextDouble())
                    {
                        divideNum2 = input.nextDouble();
                    }
                    else
                    {
                        System.out.println("Invalid input entered. Terminating...");
                        break;
                    }
                    if(divideNum2 == 0)
                    {
                         System.out.println("Invalid input entered. Terminating...");
                         break;
                    }
                    System.out.printf("Answer: %.2f%n", (divideNum1/divideNum2));
                    break;
                case "alphabetize":
                    System.out.println("Enter two words:");
                    String word1 = input.next();
                    String word2 = input.next();
                    int compareResult = word1.compareToIgnoreCase(word2);
                    if (compareResult < 0)
                    {
                        System.out.println("Answer: " + word1 + " comes before " + word2 + " alphabetically.");
                    }
                    else if(compareResult > 0)
                    {
                        System.out.println("Answer: " + word2 + " comes before " + word1 + " alphabetically.");
                    }
                    else
                    {
                        System.out.println("Answer: Chicken or Egg.");
                    }
                    break;
                default:
                    System.out.println("Invalid input entered. Terminating...");
            }

        }
    }
}