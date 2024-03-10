package LinkedList;

public class AlternateMerge {


    static class node{

        int data;
        node next;

        node(int data){
            this.data = data;
            next = null;
        }
    }

    node head;

    void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        node new_node = new node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    void printList()
    {
        node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    static node alternateMergeRecursive(node root1, node root2) {
        if(root1 == null) return root2;
        if(root2 == null) return root1;
        if(root1 == null && root2 == null) return null;

        node temp = alternateMergeRecursive(root1.next, root2.next);
        root1.next = root2;
        root2.next = temp;

        return root1;
    }

    static node alternateMergeLoop(node root1, node root2) {

        if(root1 == null) return root2;
        if(root2 == null) return root1;

        node temp1 = root1;
        while(temp1.next != null && root2 != null) {
            node newNode1 = temp1.next;
            node newNode2 = root2.next;
            temp1.next = root2;
            root2.next = newNode1;
            root2 = newNode2;
            temp1 = newNode1;
        }

        if(temp1.next == null) {
            temp1.next = root2;
        }

        return temp1;

    }
    node append(node root, int d){
        if(root == null)
            return new node(d);
        node temp = root;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new node(d);
        return root;
    }

    node alternateMerge(node  root1, node root2){
        //Complete this function
        node root = null;
        if(root1 == null) return root2;
        if(root2== null) return root1;
        while(root1 != null && root2 != null){
            root = append(root, root1.data);
            root = append(root, root2.data);
            root1 = root1.next;
            root2 = root2.next;
        }
        if(root1 != null){
            while(root1 != null){
                root = append(root, root1.data);
                root1 = root1.next;
            }
        }
        if(root2 != null){
            while(root2 != null){
                root = append(root, root2.data);
                root2 = root2.next;
            }
        }
        if(root1== null) return root2;
        if(root2== null) return root1;
        return root;
    }

    public static void main(String args[])
    {
        AlternateMerge llist1 = new AlternateMerge();
        AlternateMerge llist2 = new AlternateMerge();
        llist1.push(3);
        llist1.push(2);
        llist1.push(1);

        System.out.println("First Linked List:");
        llist1.printList();

        llist2.push(8);
        llist2.push(7);
        llist2.push(6);
        llist2.push(5);
        llist2.push(4);

        System.out.println("Second Linked List:");
        llist2.printList();

        //alternateMergeRecursive(llist1.head, llist2.head);

        alternateMergeLoop(llist1.head, llist2.head);
        System.out.println("Modified first linked list:");
        llist1.printList();

    }

}
