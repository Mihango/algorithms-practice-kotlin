package labs.khobfa.trees;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinary {
    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static Node iterative(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            Node tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }

        return root;
    }

    private static Node recursive(Node node) {
        if(node == null) return null;

        Node tmp = node.left;
        node.left = recursive(node.right);
        node.right = recursive(tmp);

        return node;
    }
}
