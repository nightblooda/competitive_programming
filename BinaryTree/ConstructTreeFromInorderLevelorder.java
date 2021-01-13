public class ConstructTreeFromInorderLevelorder {

    class Node {
        int data;
        Node left;
        Node right;

        Node(int key) {
            data = key;
            left = right = null;
        }
    }

    Node algo(int in[], int level[], int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new Node(in[start]);
        }
        boolean found = false;
        int idx = -1;
        Node root = null;
        for (int i = 0; i < level.length - 1; i++) {
            int data = level[i];
            for (int j = start; j <= end; j++) {
                if (data == in[j]) {
                    idx = j;
                    found = true;
                    root = new Node(data);
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        root.left = algo(in, level, start, idx - 1);
        root.right = algo(in, level, idx + 1, end);
        return root;
    }

    void printInorder(Node root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void main(String args[]) {
        ConstructTreeFromInorderLevelorder tree = new ConstructTreeFromInorderLevelorder();
        int in[] = new int[] { 4, 8, 10, 12, 14, 20, 22 };
        int level[] = new int[] { 20, 8, 22, 4, 12, 10, 14 };
        int n = in.length;
        Node node = tree.algo(in, level, 0, n - 1);

        /* Let us test the built tree by printing Inorder traversal */
        System.out.print("Inorder traversal of the constructed tree is ");
        tree.printInorder(node);
    }
}
