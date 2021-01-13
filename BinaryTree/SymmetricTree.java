
class Node {
    int data;
    Node left;
    Node right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

public class SymmetricTree {

    Node root;

    boolean algo(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 != null && node2 != null && node1.data == node2.data) {
            return algo(node1.left, node2.right) && algo(node1.right, node2.left);
        }
        return false;
    }

    public static void main(String args[]) {
        SymmetricTree tree = new SymmetricTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(3);
        boolean output = tree.algo(tree.root, tree.root);
        if (output == true)
            System.out.println("1");
        else
            System.out.println("0");
    }
}
