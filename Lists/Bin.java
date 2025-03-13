



public class Bin<T>{
    private T content;

    public Bin(T content)
    {
        this.content = content;
    }

    public void setContent(T content)
    {
        this.content = content;
    }

    public T getContent()
    {
        return content;
    }

    public static void main(String[] args) {
        {
            Bin<String> test = new Bin<>("I'm a basic String");
            test.setContent("short and stout");
            test.setContent("element is my handle");
            test.setContent("getContent is my spout");
            String upper = test.getContent().toUpperCase();
            System.out.println(upper);
        }
    }
}