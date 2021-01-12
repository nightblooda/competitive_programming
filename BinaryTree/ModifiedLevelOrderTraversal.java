import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ModifiedLevelOrderTraversal {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int key) {
            data = key;
            left = right = null;
        }
    }

    static void algo(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> que = new LinkedList<Node>();
        Stack<Node> stack = new Stack<>();
        int count = 0;
        boolean rightToleft = false;
        int itr = 0;
        que.add(root);
        while (!que.isEmpty()) {
            itr = que.size();
            count++;
            for (int i = 0; i < itr; i++) {
                Node temp = que.poll();
                if (rightToleft) {
                    stack.push(temp);
                } else {
                    System.out.print(temp.data + " ");
                }
                if (temp.left != null) {
                    que.add(temp.left);
                }
                if (temp.right != null) {
                    que.add(temp.right);
                }
            }
            if (rightToleft) {
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop().data + " ");
                }
            }
            if (count == 2) {
                count = 0;
                rightToleft = !rightToleft;
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(3);
        root.left.right.right = new Node(1);
        root.right.left.left = new Node(4);
        root.right.left.right = new Node(2);
        root.right.right.left = new Node(7);
        root.right.right.right = new Node(2);
        root.left.right.left.left = new Node(16);
        root.left.right.left.right = new Node(17);
        root.right.left.right.left = new Node(18);
        root.right.right.left.right = new Node(19);
        algo(root);

    }

}
