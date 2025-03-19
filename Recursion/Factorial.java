public class Factorial{
    public static void main(String[] args)
    {
        System.out.println("3 factorial is: " + computeFactorial(3));
    }

    public static int computeFactorial(int n)
    {
        if(n > 0)
        {
            return computeRealFactorial(n);
        }
        else
        {
            throw new IllegalArgumentException("Non-negative input required");
        }
    }

    public static int computeRealFactorial(int n)
    {
        if(n == 0)
        {
            return 1;
        }
        else
        {
            return n*computeRealFactorial(n-1);
        }
    }
}