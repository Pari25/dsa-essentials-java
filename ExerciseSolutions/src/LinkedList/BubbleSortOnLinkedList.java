package LinkedList;

public class BubbleSortOnLinkedList {

    class Node
    {

        int data;
        Node next;
        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;

    void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }



    static int len(Node head)
    {
        Node temp = head ;
        int i = 0 ;
        while(temp!=null)
        {
            i++;
            temp=temp.next ;
        }

        return i ;
    }

    static Node bubble_sort_LinkedList(Node head) {

        if(head == null) return head;
        int len = len(head);

        Node prev = null, cur = null;
        for(int i = 1; i < len; i++) {
            prev = null;
            cur = head;
            while(cur.next != null) {
                if(cur.data > cur.next.data) {
                    if(prev == null) {
                        prev = cur.next;
                        cur.next = prev.next;
                        prev.next = cur;
                        head = prev;

                    } else {
                        prev.next = cur.next;
                        cur.next = cur.next.next;
                        prev.next.next = cur;
                        prev = prev.next;
                    }
                } else {
                    prev = cur;
                    cur = cur.next;
                }
            }
        }

        return head;
    }

    public static void main(String args[]) {
        BubbleSortOnLinkedList llist1 = new BubbleSortOnLinkedList();
//        llist1.push(2);
//        llist1.push(5);
        llist1.push(1);
        llist1.push(3);

        System.out.println("First Linked List:");
        llist1.printList();

        head = bubble_sort_LinkedList(llist1.head);


        System.out.println("Sorted Linked List:");
        llist1.printList();
    }
}
