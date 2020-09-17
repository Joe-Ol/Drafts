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

    //finding an element in a tree structure
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
            left.in_order_print();    // Step 1
        }
        System.out.println(data);     // Step 2
        if (right != null) {
            right.in_order_print();   // step 3
        }
    }

    public void post(){
        if (right != null) {
            right.post();
        }
        if (left != null) {
            left.post();
        }
        System.out.println(data);
    }

    public static void main(String [] args) {
        Node our_tree = new Node(10);

        our_tree.add(8);
        our_tree.add(12);
        our_tree.add(17);
        our_tree.add(3);

        //our_tree.in_order_print();
        our_tree.post();
        our_tree.in_order_print();
    }
}
