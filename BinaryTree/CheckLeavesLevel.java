class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class Leaf {
    int leafLevel = 0;
}

public class CheckLeavesLevel {

    Node root;
    Leaf leaf = new Leaf();

    boolean check(Node node) {
        return check(node, 0, leaf);
    }

    boolean check(Node node, int level, Leaf leaf) {
        if (node == null) {
            return true;
        }
        if (node.left == null && node.right == null) {
            if (leaf.leafLevel == 0) {
                leaf.leafLevel = level;
                return true;
            }
            if (leaf.leafLevel == level) {
                return true;
            }
        }
        return check(node.left, level + 1, leaf) && check(node.right, level + 1, leaf);
    }

    public static void main(String args[]) {
        // Let us create the tree as shown in the example
        CheckLeavesLevel tree = new CheckLeavesLevel();
        tree.root = new Node(12);
        tree.root.left = new Node(5);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(9);
        tree.root.left.left.left = new Node(1);
        tree.root.left.right.left = new Node(1);
        if (tree.check(tree.root))
            System.out.println("Leaves are at same level");
        else
            System.out.println("Leaves are not at same level");
    }
}
