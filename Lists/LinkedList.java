
import java.util.Objects;

public class LinkedList<E>{

    private class Node<E>{
        private E data;
        private Node<E> next;

        private Node(E data, Node<E> next)
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
            String message = "Index out of bounds: " + String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }
        //Add element at specified index

        if(index == 0)
        {
            head = new Node<E>(data, head);
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
        if(isEmpty())
            return false;
        
        Node<E> current = head;
        while(current != null)
        {
            if(Objects.equals(current.data, O))
                return true;
            current = current.next;
        }
        return false;
    }

    public E get(int index)
    {
        if(index < 0 || index >= size)
        {
            String message = "Index out of bounds: " + String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }
        Node<E> current = head;
        for(int i=0; i < index; i++)
        {
            current = current.next;
        }

        return current.data;
    }

    public int indexOf(Object O)
    {
        Node<E> current = head;
        int index = 0;

        while(current!=null)
        {
            if((O == null && current.data == null) || (O !=null && Objects.equals(current.data, O)))
            {
             return index;
            }
            current = current.next;
            index+=1;
        }
        return -1;
    }

    public E remove(int index)
    {
        if(index < 0 || index >= size)
        {
            String message = "Index out of bounds: " + String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }
        Node<E> current = head;

        if(index == 0)
        {
            head = head.next;
        }
        else
        {
            Node<E> previousNode = head;
            for(int i = 0; i < index - 1; i++)
            {   
                previousNode = previousNode.next;
            }
            current = previousNode.next;
            previousNode.next = current.next;
        }
        
        size--;
        return current.data;
    }

    public boolean remove(Object O)
    {
        //decrement size if item was removed
        if(head == null)
        {
            return false;
        }

        //Handle removal of head separetely
        if(Objects.equals(head.data, O))
        {
            head = head.next;
            size--;
            return true;
        }

        Node<E> current = head;
        Node<E> previous = null;

        while(current!=null)
        {
            if(Objects.equals(current.data, O))
            {
                previous.next = current.next;
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }
    //Method that updates the value at an indes and returns the old data object
    public E set(int index, E newData)
    {
        //Return error if index < 0 or greater than the size of the linked list
        if(index < 0 || index >= size)
        {
            String message = "Index out of bounds: " + String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }
        Node<E> current = head;
        for(int i = 0; i< index; i++)
        {
            current = current.next;
        }

        E oldData = current.data;

        current.data = newData;

        return oldData;
    }

    //Method that returns a string representation of a generic linked list in Java
    @Override
    public String toString()
    {
        String result = "[";
        //Return an empty string if the list is empty
        if(head == null)
        {
            return "[]";
        }

        //return items in the list for a populated list
        Node<E> current = head;

        while(current.next != null)
        {
            result += String.valueOf(current.data) + ", ";
            current = current.next;
        }

        result += String.valueOf(current.data) + "]";
        return result;
    }

    public boolean equals(Object O)
    {
        return true;
    }
}