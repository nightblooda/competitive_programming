import java.util.HashMap;
import java.util.Vector;
import java.util.Map.Entry;

public class DiagonalTraversal {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int key) {
            data = key;
            left = right = null;
        }
    }

    static void algo(HashMap<Integer, Vector<Integer>> map, int d, Node root) {
        if (root == null) {
            return;
        }
        Vector<Integer> v = map.get(d);
        if (v == null) {
            v = new Vector<Integer>();
        }
        v.add(root.data);
        map.put(d, v);
        algo(map, d + 1, root.left);
        algo(map, d, root.right);
    }

    public static void main(String[] args) {

        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);

        HashMap<Integer, Vector<Integer>> map = new HashMap<>();
        algo(map, 0, root);
        System.out.println("Diagonal Tree Traversal: ");
        for (Entry<Integer, Vector<Integer>> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
