import java.util.LinkedList;
import java.util.Queue;

public class InsertionDeletion {

    static class Node {
        int key;
        Node right;
        Node left;

        Node(int key) {
            this.key = key;
            right = left = null;
        }
    }

    static void insert(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return;
        }
        Queue<Node> que = new LinkedList<Node>();
        que.add(root);
        while (!que.isEmpty()) {
            Node temp = que.poll();
            if (temp.left == null) {
                temp.left = new Node(key);
                break;
            } else if (temp.right == null) {
                temp.right = new Node(key);
                break;
            } else {
                que.add(temp.left);
                que.add(temp.right);
            }
        }
    }

    static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }

    static int deleteDeepest(Node root){
        Node temp = root;
        while(temp != null){
            Node temp = que.poll();
            if(temp.right != null)

        }
    }

    static void delete(Node root, int key) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (root.key == key) {
                root = null;
                return;
            }
        }
        Queue<Node> que = new LinkedList<Node>();
        que.add(root);
        Node keyNode = null;
        while (!que.isEmpty()) {
            Node temp = que.poll();
            if (temp.key == key) {
                keyNode = temp;
                break;
            }
            if (temp.right != null) {
                que.add(temp.right);
            }
            if (temp.left != null) {
                que.add(temp.left);
            }
        }
        if (keyNode == null) {
            return;
        }
        int val = deleteDeepest(root);
        keyNode.key = val;
    }

    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.left.right = new Node(12);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        System.out.print("Inorder traversal " + "before insertion:");
        inorder(root);

        int key = 16;
        insert(root, key);

        System.out.print("\nInorder traversal " + "after insertion:");
        inorder(root);

        System.out.println("Inorder traversal before deletion:");
        inorder(root);

        System.out.println("Inorder traversal after deletion: ");

        key = 11;
        delete(root, key);
        inorder(root);

    }

}