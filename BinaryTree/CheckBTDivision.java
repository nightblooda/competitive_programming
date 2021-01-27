class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class Res {
    boolean res = false;
}

public class CheckBTDivision {

    int count(Node node) {
        if (node == null) {
            return 0;
        }
        return count(node.left) + count(node.right) + 1;
    }

    int checkUtil(Node node, int n, Res res) {
        if (node == null) {
            return 0;
        }
        int c = checkUtil(node.left, n, res) + checkUtil(node.right, n, res) + 1;
        if (c == n - c) {
            res.res = true;
        }
        return c;
    }

    Node root;

    boolean check(Node node) {
        int n = count(node);
        Res res = new Res();
        checkUtil(node, n, res);
        return res.res;
    }

    public static void main(String[] args) {
        CheckBTDivision tree = new CheckBTDivision();
        tree.root = new Node(5);
        tree.root.left = new Node(1);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(3);
        tree.root.right.left = new Node(7);
        tree.root.right.right = new Node(4);
        if (tree.check(tree.root) == true)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

}
