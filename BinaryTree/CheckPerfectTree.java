class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

public class CheckPerfectTree {

    static int findDepth(Node node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.left;
        }
        return count;
    }

    static boolean isPerfectUtil(Node node, int d, int level) {
        if (node == null) {
            return true;
        }
        if (node.left == null && node.right == null) {
            return level + 1 == d;
        }
        if (node.left == null || node.right == null) {
            return false;
        }
        return isPerfectUtil(node.left, d, level + 1) && isPerfectUtil(node.right, d, level + 1);
    }

    static boolean isPerfect(Node node) {
        int d = findDepth(node);
        return isPerfectUtil(node, d, 0);
    }

    public static void main(String args[]) {
        Node root = null;
        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);

        if (isPerfect(root) == true)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

}
