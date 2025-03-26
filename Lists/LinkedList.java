public class LinkedList<E>{

    private class Node<E>{
        E data;
        Node<E> next;

        Node(E data, Node<E> next)
        {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;
    private int size; //Any method that changes the size of the list should update this

    public LinkedList()
    {
        head = null;
        size = 0;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return (head == null) && (size == 0);
    }

    public void clear()
    {
       head = null;
       size = 0;
    }

    public void add(int index, E data)
    {
        if(index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size + ". Cannot add element at the specified index.");
        }
    }
}