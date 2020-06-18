package labs.khobfa.graphs;

import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {

    boolean[] visited;
    Stack<Integer> stack;

    static class DiGraph {
        int vertices;
        int edges;
        LinkedList<Integer>[] adjacent;

        public DiGraph(int v) {
            this.vertices = v;
            adjacent = new LinkedList[v];

            for (int i =0; i < v; i++) {
                adjacent[i] = new LinkedList<>();
            }
        }

        public void addEdge(int v, int w) {
            adjacent[v].add(w);
            edges++;
        }

        public int getVertices() {
            return vertices;
        }

        public Iterable<Integer> getAdj(int vertex) {
            return adjacent[vertex];
        }
    }

    // reverse post order is similar to topological sort
    public Stack<Integer> reversePostOrder(DiGraph diGraph) {
        visited = new boolean[diGraph.vertices];
        stack = new Stack<>();
        for(int v = 0; v < diGraph.vertices; v++) {
            if(!visited[v]) {
                dfs(diGraph, v);
            }
        }
        return stack;
    }

    private void dfs(DiGraph diGraph, int vertex) {
        visited[vertex] = true;

        for (int node: diGraph.getAdj(vertex)) {
            if(!visited[node]) {
                dfs(diGraph, node);
            }
        }
        stack.push(vertex);
    }

    public static DiGraph creteGraph() {
        TopologicalSort.DiGraph diGraph = new TopologicalSort.DiGraph(7);
        diGraph.addEdge(0, 1);
        diGraph.addEdge(0, 2);
        diGraph.addEdge(0, 5);
        diGraph.addEdge(1, 4);
        diGraph.addEdge(5, 2);
        diGraph.addEdge(3, 5);
        diGraph.addEdge(3, 2);
        diGraph.addEdge(3, 4);
        diGraph.addEdge(3, 6);
        diGraph.addEdge(6, 4);
        diGraph.addEdge(6, 0);

        return diGraph;
    }

    public static void main(String[] args) {
        TopologicalSort sort = new TopologicalSort();
        Stack<Integer> stack = sort.reversePostOrder(creteGraph());

        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
