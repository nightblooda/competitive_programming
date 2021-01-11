import java.util.Stack;

class Node {
    int data;
    Node left, right;

    public Node(int key) {
        data = key;
        left = right = null;
    }
}

public class InorderWithoutRecursion {

    Node root;

    public void algo() {
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || stack.size() > 0) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.print(cur.data + " ");
            cur = cur.right;
        }
    }

    public static void main(String args[]) {

        InorderWithoutRecursion tree = new InorderWithoutRecursion();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.algo();
    }
}
