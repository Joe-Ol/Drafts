public class Linked_Lists {


    /*
    We declare a Head node to ensure all nodes point back to one 'HEAD/START'
    in the cases where we append new nodes at the beginning i.e. prepend/insert
    at head.

    */
    Node head;



    // We then create a nested 'Node' class to house our node objects & constructor
    class Node {
        Node next;   int data;
        public Node(int data) {this.data = data;} // Node constructor
    }


    // First Method: to add new nodes to an Empty/Occupied Linked List
    public void add(int data) {
        // In the event that the head dose not exist i.e. in an empty Linked List, then we
        // assign whatever node we wanted to append as our 'HEAD'
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node current = head;    // To tell us where to start

        // While loop to ensure we visit all nodes till we get to then end of the linked list
        // i.e. current.next != null we haven't reach the end.

        while (current.next != null) {
            current = current.next;
        }
        // Create a new node once we get to the end of the Linked List
        current.next = new Node(data);
    }


    // Second Method: to add a node at the Start/Head position
    public void insert(int data) {
        Node newHead = new Node(data);  // We first create a new Head Value
        newHead.next = head;            // Ensure our newHead point to the old 'Head'
        head = newHead;                 // Reset Head to be newHead which we just created
    }

    // Third Function: to delete a node with a specific value
    // In case of two nodes having the same value of interest, the first node is 'deleted'
    public void delete(int data) {
        if (head == null) return;   // Check if our list is empty first

        // In some cases, the value may be in the head node hence we would need to update
        // our 'Head' detail by ensuring whatever came next after the head is made the new Head
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node current = head;    // To tell us where to start

        // We then loop over the LL till we locate our value(data) of interest
        while (current.next != null) {

            // Once we locate the node with the value we wish to delete, we skip to the node right after
            // hence we reassign pointer resulting in a skipped node i.e. 'deleted node'
            if (current.next.data == data) {        // Value identification
                current.next = current.next.next;   // Skipping node with value of interest & Pointer re-assignment
                return;
            }
            current = current.next;
        }
    }


    // Fourth Method: Print output
    public void print() {
        Node current = head;    // To tell us where to start

        System.out.println("   ");
        // Loop and print out data at every node
        while (current != null) {
            System.out.println(current.data+"");
            current = current.next;
        }
    }


    // Test our methods/functions
    public static void main(String [] args){
        Linked_Lists scores = new Linked_Lists();

        scores.add(60);
        scores.add(180);
        scores.add(150);
        scores.add(150);
        scores.add(20);
        scores.add(100);
        scores.add(150);
        scores.print();


        scores.insert(90);
        scores.print();


        scores.delete(150);
        scores.delete(100);
        scores.print();

    }
}
