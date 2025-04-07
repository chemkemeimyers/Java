public class GenericLinkedList<E>{
    private class Node<E>{
        E data;
        Node<E> next;
        Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;
    public GenericLinkedList(){
        head = null;
    }
    public void kindLatin(){
        Node<E> current = head;
        while(current != null)
        {
            System.out.println(current.data.toString() + "pls");
            current = current.next;
        }
    }
    public boolean isEmpty()
    {
        return head == null;
    }
    public void addToRear(E newData)
    {
        Node newNode = new Node(newData, null);

        if(isEmpty())
        {
            head = newNode;
        }
        else{
            Node current = head;
            while(current.next!=null)
            {
                current = current.next;
            }
            current.next = newNode;
        }
    }

}