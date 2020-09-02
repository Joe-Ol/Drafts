public class queues {

    private static class Node {
        private int data;
        private Node next;
        private Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;


    // Method 1: To check if structure is empty.
    public boolean isEmpty() {
        return head == null;
    }

    //Method 2: To add an element/node at the back.
    public void add(int data) {
        Node node = new Node(data);  // Create new node

        if (tail != null) {           // Check if tail/back exists
            tail.next = node;         // Assign new node to tail
        }

        tail = node;                  // Reassign the tail

        if (head == null) {           // Check if queue is empty
            head = node;              // Assign new node to be head
        }
    }

    //Method 3:  To leave the queue at the cafe
    public int remove() {
        int data = head.data;       //  Identify what to leave (what to be removed from the structure)
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return data;

    }


    public static void main(String[] args) {
        queues student_numbers = new queues();

        student_numbers.add(101190);
        student_numbers.add(111761);
        student_numbers.add(111885);

        while (!student_numbers.isEmpty()){
            System.out.println(student_numbers.remove());
        }

        System.out.println("---------------");
        student_numbers.add(101190);
        student_numbers.add(111761);
        student_numbers.add(111885);
        student_numbers.add(120751);
        student_numbers.add(121569);
        student_numbers.remove();

        while (!student_numbers.isEmpty()){
            System.out.println(student_numbers.remove());
        }
    }
}
