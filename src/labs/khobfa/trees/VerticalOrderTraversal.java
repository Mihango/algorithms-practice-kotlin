package labs.khobfa.trees;

import kotlin.Pair;

import java.util.*;

import static java.util.Map.Entry.comparingByKey;

public class VerticalOrderTraversal {

    static class Pair<TreeNode, Value> {
        TreeNode node;
        Value index;

        Pair(TreeNode node, Value index) {
            this.node = node;
            this.index = index;
        }
    }

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public int getVal() {
            return val;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    }

    @SuppressWarnings("Unchecked")
    public static List<List<Integer>> verticalOrder(Node root) {
        List<List<Integer>> output = new ArrayList<>();

        if (root == null) return output;

        Map<Integer, ArrayList<Integer>> columnTable = new HashMap<>();
        Queue<Pair<Node, Integer>> queue = new ArrayDeque<>();
        int column = 0;
        queue.offer(new Pair<>(root, column));

        while (!queue.isEmpty()) {
            Pair<Node, Integer> p = queue.poll();
            root = p.node;
            column = p.index;

            if (root != null) {
                if (!columnTable.containsKey(column)) {
                    columnTable.put(column, new ArrayList<>());
                }
                columnTable.get(column).add(root.val);
                queue.offer(new Pair<>(root.left, column - 1));
                queue.offer(new Pair<>(root.right, column + 1));
            }
        }

        List<Integer> sortedKeys = new ArrayList<>(columnTable.keySet());
        Collections.sort(sortedKeys);
        for (int k : sortedKeys)
            output.add(columnTable.get(k));

        return output;
    }

    public static List<List<Integer>> verticalTraversal(Node root) {
        List<List<Integer>> data = new ArrayList<>();

        if (root == null) return data;

        Queue<Pair<Node, Integer>> queue = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int col = 0;
        queue.add(new Pair<>(root, col));

        while (!queue.isEmpty()) {
            Pair<Node, Integer> pair = queue.remove();
            col = pair.index;

            if (pair.node.left != null) queue.add(new Pair<>(pair.node.left, col - 1));
            if (pair.node.right != null) queue.add(new Pair<>(pair.node.right, col + 1));

            // add node to hash map
            map.computeIfAbsent(col, k -> new ArrayList<>());
            map.get(col).add(pair.node.val);
        }

        map.entrySet()
                .stream()
                .sorted(comparingByKey())
                .forEach(i -> data.add(i.getValue()));

        return data;
    }

    public static void main(String[] args) {

        Node n15 = new Node(15);
        Node n7 = new Node(7);

        Node n20 = new Node(20, n15, n15);
        Node n9 = new Node(9);
        Node n3 = new Node(3, n9, n20);

        List<List<Integer>> result = verticalOrder(n3);
        for (List<Integer> list : result) {
            System.out.println(list.toString());
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        result = verticalTraversal(n3);
        for (List<Integer> list : result) {
            System.out.println(list.toString());
        }
    }
}
