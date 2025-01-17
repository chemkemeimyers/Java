public class searchStringArray{
    public static void main(String[] args)
    {
        String[] concepts = {"abstraction","polymorphism","inheritance","encapsulation"};

        
        System.out.println(searchStringArray.SearchArrayForWord(concepts,"abstraction"));
        System.out.println(searchStringArray.SearchArrayForWord(concepts,"yay"));
        System.out.println(searchStringArray.SearchArrayForWord(concepts,"polymorphism"));
    }
    public static String SearchArrayForWord(String[] arrayToSearch, String targetWord)
        {
            String result = "Not found";
            for(String word: arrayToSearch)
            {
                if(word.equals(targetWord))
                {
                    result = "found";
                    break;
                }
            }
            return result;
        }
}