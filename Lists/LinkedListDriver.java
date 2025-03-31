public class LinkedListDriver
{
    public static void main(String[] args) {
        {
            LinkedList ll = new LinkedList();
            ll.add(1);
            ll.add(2);
            ll.add(3);
            ll.add(null);
            ll.add(5);
            System.out.println(ll.size());
            System.out.println(ll.toString());
            System.out.println(ll.contains(null));
        }
    }

}