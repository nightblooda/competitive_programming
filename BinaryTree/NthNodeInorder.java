public class NthNodeInorder {
    static int count = 0;

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int key) {
            data = key;
            left = right = null;
        }
    }

    public static void algo(Node root, int n) {
        if (root == null) {
            return;
        }
        if (count <= n) {
            algo(root.left, n);
            count++;
            if (count == n) {
                System.out.println("Nth node is: " + root.data);
            }
            algo(root.right, n);
        }
    }

    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);

        int n = 4;

        algo(root, n);
    }
}
