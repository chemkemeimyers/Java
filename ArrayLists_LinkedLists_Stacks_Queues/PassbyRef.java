public class PassbyRef {

    //Empty constructur for class PassbyRef
    public PassbyRef()
    {

    }

    //A static function that takes an integer x and increments it by 1. The function returns the incremented integer value
    public static int helper(int x)
    {
        x = x + 1;
        return x;
    }

    //Main method that calls the helper method on a value count and prints the output to the terminal
    public static void main(String[] args)
    {
        int count = 0;
        count = helper(count);
        System.out.println(count);
    }
    
}
