public class PassByValorRef {
    public PassByValorRef()
    {

    }

    public static void helper(int x)
    {
        x = x + 1;
    }

    public static void main(String[] args)
    {
    int count = 0;
    helper(count);
    System.out.println("Count: " + count);

    }
    
}



