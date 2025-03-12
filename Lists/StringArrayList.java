import java.util.ArrayList;
public class StringArrayList{
    public static void main(String[] args)
    {
        ArrayList<String> playlist = new ArrayList<>();
        playlist.add("Humpty Dumpty");
        playlist.add("Swing Low Sweet Chariot");
        playlist.add("Itsy Bitsy Spider");
        playlist.add("Twinkle, Twinkle Little Star");
        playlist.add("Wheels on the bus");
        System.out.println(playlist.toString());

        playlist.remove("Humpty Dumpty");
        System.out.println(playlist.toString());
        System.out.println(playlist.contains("Humpty Dumpty"));
        System.out.println(playlist.contains("Itsy Bitsy Spider"));
        playlist.add("Humpty Dumpty");
        System.out.println(playlist.toString());
    }
}