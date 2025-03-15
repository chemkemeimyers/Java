
import java.util.LinkedList;

public class GenericLinkedList<E> {
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

    public GenericLinkedList()
    {
        head = null; //the list starts off empty
    }

    public boolean isEmpty()
    {
        return (head == null);
    }

    public void addToFront(E newData)
    {
        head = new Node<E> (newData, head);
    }

    public void addToRear(E newData)
    {
        Node<E> node = new Node<E>(newData, null);
        Node<E> current = head;

        if(isEmpty())
            head = node;
        else
        {
            while(current.next != null)
            {
                current = current.next;
            }
            current.next = node;
        }
    }

    public String toString()
    {
        Node<E> current = head;
        String result = "";

        while(current != null)
        {
            result = result + current.data.toString() + "\n";
            current = current.next;
        }
        return result;
    }

    public boolean contains(E target)
    {
        Node<E> current = head;
        if(isEmpty())
            return false;

        boolean found = false;
       
        while(current.next != null  && !found)
        {
            if(target.equals(current.data))
                found = true;
            else
                current = current.next;
        }
        return found;
       
    }

    public E removeFromFront()
    {
       if(isEmpty())
        {
            return null;
        }

        E result = head.data;
        head = head.next;

        return result;
    }

    public E removeFromRear()
    {
        if(isEmpty())
            return null;
        
        Node<E> current = head;

        //Case of a single node
        if(head.next == null)
        {
            E result = head.data;
            head = null;
            return result;
        }

        while(current.next.next != null)
        {
            current =  current.next;
        }
        Node<E> result = current.next;
        current.next = null;
        return result.data;
    }

    public static void main(String[] args) {
        {
            GenericLinkedList<String> favBabySongs = new GenericLinkedList<String>();
            favBabySongs.addToFront("Humpty Dumpty");
            favBabySongs.addToRear("Swing Low Sweet Chariot");
            favBabySongs.addToFront("Itsy Bitsy Spider");
            favBabySongs.addToRear("Twinkle, Twinkle Little Star");
            favBabySongs.addToFront("Wheels on the Bus");
            System.out.println(favBabySongs.toString());
            System.out.println(favBabySongs.contains("Humpty Dumpty"));
            System.out.println(favBabySongs.contains("Baby Shark"));
        }
    }
}