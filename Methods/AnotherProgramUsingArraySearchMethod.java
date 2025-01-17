public class AnotherProgramUsingArraySearchMethod{
    public static void main(String[] args)
    {
        String[] lullabies = {"Wheels on the bus",
                              "Twinke, Twinkle Little Star",
                              "Itsy Bitsy Spider",
                              "Swing low sweet chariot",
                              "Amazing Grace"};
        System.out.println(searchStringArray.SearchArrayForWord(lullabies,"Amazing Grace"));
        System.out.println(searchStringArray.SearchArrayForWord(lullabies,"Humpty Dumpty"));

        System.out.println(ArraySearch.searchArray(lullabies,"Amazing Grace"));

        int[] weekHighs = {80, 70, 75, 69, 43, 39};
        System.out.println(ArraySearch.searchArray(weekHighs, 90));
    }
}