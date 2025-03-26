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
        //Handle case where we cannot add an element at the specified index
        if(index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size + ". Cannot add element at the specified index.");
        }
        //Add element at specified index

        if(index == 0)
        {
            head = new Node<E>(data, null);
        }
        else
        {
            Node<E> current = head;
            for(int i=0; i < index-1; i++)
            {
                current = current.next;
            }
            current.next = new Node<E>(data, current.next);
            
        }
        size++;
    }

    public void add(E data)
    {
        add(size, data);
    }

    public boolean contains(Object O)
    {
        E data = (E)O;
        if(isEmpty())
            return false;
        
        Node<E> current = head;
        while(current != null)
        {
            if(current.data.equals(data))
                return true;
            current = current.next;
        }
        return false;
    }
}