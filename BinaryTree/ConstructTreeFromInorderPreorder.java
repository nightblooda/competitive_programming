public class ConstructTreeFromInorderPreorder {

    class Node {
        char data;
        Node left;
        Node right;

        Node(char key) {
            data = key;
            left = right = null;
        }
    }

    Node root;
    int preorder = 0;

    Node algo(char in[], char pre[], int start, int end) {
        if (start > end) {
            return null;
        }
        Node temp = new Node(pre[preorder++]);
        if (start == end) {
            return temp;
        }
        int idx = search(in, temp.data, start, end);
        temp.left = algo(in, pre, start, idx - 1);
        temp.right = algo(in, pre, idx + 1, end);
        return temp;
    }

    int search(char in[], char data, int start, int end) {
        int i;
        for (i = start; i <= end; i++) {
            if (in[i] == data) {
                return i;
            }
        }
        return i;
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
        ConstructTreeFromInorderPreorder tree = new ConstructTreeFromInorderPreorder();
        char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
        char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
        int len = in.length;
        Node root = tree.algo(in, pre, 0, len - 1);

        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        tree.printInorder(root);
    }
}
