public class RecursiveMethod{
    public static void recursiveMethod(int n)
    {
        if (n <= 0)
        {
            return;
        }
        else
        {
            System.out.println(n);
            recursiveMethod(n-2);
            System.out.println(n-1);
        }
    }

    public static void main(String[] args) {
        {
            int num = 7;
            recursiveMethod(num);
        }
    }
}