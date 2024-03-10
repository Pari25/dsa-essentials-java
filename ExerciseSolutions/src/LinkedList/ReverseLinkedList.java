package LinkedList;

public class ReverseLinkedList {

    class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }
    };

    Node reverse(Node head){

        if(head == null) return head;
        Node prev = null;
        Node cur = head;
        Node next = head;

        while(cur != null) {
            next = next.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
