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
}