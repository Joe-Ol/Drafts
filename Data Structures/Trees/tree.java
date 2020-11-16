class Node{
    Node left, right;
    int data;
    public Node(int data) {
        this.data = data;
    }

    // Adding a node to the tree
    public void add(int value) {
        if (value <= data) {
            if (left == null) {
                left = new Node(value);
            } else {
                left.add(value);
            }
        } else {
            if (right == null) {
                right = new Node(value);
            } else {
                right.add(value);
            }
        }
    }

    //finding an element in a tree structure  (SEARCH) , Comment each step accordingly
    public boolean check(int value) {
        if (value == data) {
            return true;
        } else if (value < data) {
            if (left == null) {
                return false;
            } else {
                return left.check(value);
            }
        } else {
            if (right == null){
                return false;
            } else {
                return right.check(value);
            }
        }
    }


    public void in_order_print(){
        if (left != null) {
            left.in_order_print();      // Step 1
        }
        System.out.println(data);       // Step 2
        if (right != null) {
            right.in_order_print();     // Step 3
        }
    }

    public void post_order(){
        if (right != null) {
            right.post_order();
        }
        if (left != null) {
            left.post_order();
        }
        System.out.println(data);
    }

    public void pre_order(){        //Finish writing this method

    }

    public static void main(String [] args) {
        Node our_tree = new Node(10);

        our_tree.add(8);
        our_tree.add(12);
        our_tree.add(17);
        our_tree.add(3);

        System.out.println("Post Order");
        our_tree.in_order_print();
        System.out.println("Post Order");
        our_tree.post_order();

    }
}
