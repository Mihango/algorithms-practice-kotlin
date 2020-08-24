package labs.khobfa.trees;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Huffman {

    static class Node {
        Integer freq;
        char val;
        Node left;
        Node right;

        Node(Integer freq, char val) {
            this.freq = freq;
            this.val = val;
        }
    }

    public static Node create(char[] arr, int[] freq) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.freq));

        for (int i = 0; i<arr.length;i++) {
            queue.add(new Node(freq[i], arr[i]));
        }

        while (queue.size() > 1) {
            Node x = queue.remove();
            Node y = queue.remove();

            Node node = new Node(x.freq + y.freq, ' ');
            node.left = x;
            node.right = y;
            queue.add(node);
        }

        return queue.remove();
    }

    private static String printCode(Node node, String s) {
        if(node.left == null && node.right == null && Character.isLetter(node.val)) {
            System.out.println(node.val + ": " + s);
            return s;
        }

        assert node.left != null;
        String s1 = printCode(node.left, s + "0");
        String s2 = printCode(node.right, s + "1");
        return s1 + s2;
    }

    private static String decode(Node root, String s) {
        if(root == null || s.isEmpty()) return "";
        StringBuilder builder = new StringBuilder();
        Node node = root;

        for(int i=0; i<s.length();i++) {
            node = s.charAt(i) == '1' ? node.right : node.left;
            if(node.left == null && node.right == null) {
                builder.append(node.val);
                node = root;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Node node = create(new char[]{'a', 'b', 'c', 'd', 'e', 'f'}, new int[]{5, 9, 12, 13, 16, 45});
        String result = printCode(node, "");
        System.out.println(result);
        System.out.println("decoded " + decode(node, result));
    }
}
