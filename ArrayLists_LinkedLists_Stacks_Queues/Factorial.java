public class Factorial{
    //Class to implement factorial method which uses recursion
    
    public static int factorial(int n) throws IllegalArgumentException
    {
        if(n < 0) //Exception case
        {
            throw new IllegalArgumentException();
        }
        else if(n == 0)
        {
            return 1; //base case 
        }
        else{
            return n*factorial(n-1); //recursive case
        }
    }

    public static void main(String[] args)
    {
        int num = 4;
        int result = factorial(num);
        System.out.println("Factorial of " + num + " is " + result);
    }
}