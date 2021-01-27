class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

public class CheckFullTree {

    Node root;

    boolean isFullTree(Node node) {
        if (node == null) {
            return true;
        }
        if (node.left == null && node.right == null) {
            return true;
        }
        if (node.left != null && node.right != null) {
            return isFullTree(node.left) && isFullTree(node.right);
        }
        return false;
    }

    public static void main(String args[]) {
        CheckFullTree tree = new CheckFullTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.left.left = new Node(4);
        tree.root.left.left.left = new Node(6);
        tree.root.left.left.right = new Node(7);

        if (tree.isFullTree(tree.root))
            System.out.print("The binary tree is full");
        else
            System.out.print("The binary tree is not full");
    }

}
