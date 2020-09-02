import java.util.EmptyStackException;

public class stacks {
    private static class Node {
        private int data;
        private stacks.Node next;
        private Node(int data) {
            this.data = data;
        }
    }

    private Node top;  // Track the top

    // Method 1: To check if structure is empty.
    public boolean isEmpty() {
        return top == null;
    }

    // Method 2: Peek.
    public int peek() {
        return top.data; // throws exception if top == null
    }

    // Method 3: Add node at top.
    public void push(int data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
    }


    // Method 4: Remove node at top.
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int data = top.data;
        top = top.next;
        return data;
    }


    public static void main(String [] args){
        stacks_test prices = new stacks_test();

        prices.isEmpty();
        System.out.println("STACKS");
        prices.push(150);
        prices.push(200);
        prices.push(2);
        prices.push(45);
        prices.push(12);
        prices.peek();
        while (!prices.isEmpty()) {
            System.out.println(prices.pop());
        }

        System.out.println("--------");

        prices.push(150);
        prices.push(200);
        prices.push(2);
        prices.push(45);
        prices.push(12);
        prices.pop();
        while (!prices.isEmpty()) {
            System.out.println(prices.pop());
        }

    }
}


