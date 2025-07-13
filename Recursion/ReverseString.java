//Program to reverse a string using recursion
public class ReverseString{

    //Method to reverse a string recursively
    //Input: String
    //Output: A singe character at a time starting with the last char until the first char through a recursive call
    public static String reverseString(String theString)
    {
        int index = theString.length();
        if(index == 0)
        {
            return "";
        }
        else
        {
            return String.valueOf(theString.charAt(index-1)) + reverseString(theString.substring(0, index-1));
        }
    }

    public static void main(String[] args)
    {
        String word = "Hope";
        System.out.print("Attempt reversing the string: " + word + "\n");
        System.out.print("Reversed result: " + reverseString(word));

    }

}