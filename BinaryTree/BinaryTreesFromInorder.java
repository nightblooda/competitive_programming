import java.util.Vector;

public class BinaryTreesFromInorder {

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int key) {
            data = key;
            left = right = null;
        }
    }

    Vector<Node> getTrees(int in[], int start, int end) {
        Vector<Node> trees = new Vector<>();
        if (start > end) {
            trees.add(null);
            return trees;
        }
        for (int i = start; i <= end; i++) {
            Vector<Node> ltrees = getTrees(in, start, i - 1);
            Vector<Node> rtrees = getTrees(in, i + 1, end);
            for (int j = 0; j < ltrees.size(); j++) {
                for (int k = 0; k < rtrees.size(); k++) {
                    Node tree = new Node(in[i]);
                    tree.left = ltrees.get(j);
                    tree.right = rtrees.get(k);
                    trees.add(tree);
                }
            }
        }
        return trees;
    }

    void preorder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String args[]) {
        int in[] = { 4, 5, 7 };
        int n = in.length;
        BinaryTreesFromInorder tree = new BinaryTreesFromInorder();
        Vector<Node> trees = tree.getTrees(in, 0, n - 1);
        System.out.println("Preorder traversal of different binary tree: ");
        for (int i = 0; i < trees.size(); i++) {
            tree.preorder(trees.get(i));
            System.out.println();
        }
    }
}
