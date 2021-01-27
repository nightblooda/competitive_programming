public class BinaryTreeToDLL {

    static class node {
        int data;
        node left, right;

        node(int key) {
            data = key;
            left = right = null;
        }
    }

    static node prev;

    static void handlePrev(node root) {
        if (root == null) {
            return;
        }
        handlePrev(root.left);
        root.left = prev;
        prev = root;
        handlePrev(root.right);
    }

    static node handleNext(node root) {
        if (root == null) {
            return root;
        }
        while (root.right != null) {
            root = root.right;
        }
        while (root != null && root.left != null) {
            node left = root.left;
            left.right = root;
            root = root.left;
        }
        return root;
    }

    static node BTTtoDLL(node root) {
        if (root == null) {
            return root;
        }
        prev = null;
        handlePrev(root);
        return handleNext(root);
    }

    static void inorder(node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    static void printlist(node root) {

        while (root != null) {
            System.out.print(root.data + " ");
            root = root.right;
        }
    }

    public static void main(String[] args) {
        // Let us create the tree shown in above diagram
        node root = new node(10);
        root.left = new node(12);
        root.right = new node(15);
        root.left.left = new node(25);
        root.left.right = new node(30);
        root.right.left = new node(36);

        System.out.println("Inorder Tree Traversal");
        inorder(root);

        node head = BTTtoDLL(root);

        System.out.println("\nDLL Traversal");
        printlist(head);
    }

}
