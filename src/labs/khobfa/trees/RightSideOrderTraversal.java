package labs.khobfa.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideOrderTraversal {

    public static List<Integer> rightSideView(VerticalOrderTraversal.Node root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) return result;

        int row = 0;
        Queue<VerticalOrderTraversal.Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                VerticalOrderTraversal.Node node = queue.remove();

                if(node.getRight() != null) queue.add(node.getRight());
                if(node.getLeft() != null) queue.add(node.getLeft());

                if(i == 0) result.add(row++, node.getVal());
            }
        }

        return result;
    }

    public static void main(String[] args) {

        VerticalOrderTraversal.Node n15 = new VerticalOrderTraversal.Node(15);
        VerticalOrderTraversal.Node n7 = new VerticalOrderTraversal.Node(7);

        VerticalOrderTraversal.Node n20 = new VerticalOrderTraversal.Node(20, n15, n15);
        VerticalOrderTraversal.Node n9 = new VerticalOrderTraversal.Node(9);
        VerticalOrderTraversal.Node n3 = new VerticalOrderTraversal.Node(3, n9, n20);

        List<Integer> result = rightSideView(n3);
        for (Integer item : result) {
            System.out.println(item);
        }

    }
}
