package labs.khobfa.graphs;

import javax.swing.*;

public class CycleDetector {

    public static boolean hasCycle(TopologicalSort.DiGraph diGraph) {
        boolean hasCycle = false;
        boolean[] visited = new boolean[diGraph.vertices];
        boolean[] onStack = new boolean[diGraph.vertices];

        for (int i = 0; i < diGraph.vertices; i++) {
           if(!visited[i] && !hasCycle)
               hasCycle = dfs(diGraph, i, visited, onStack);
           if(hasCycle)
               break;
        }

        return hasCycle;
    }

    static boolean dfs(TopologicalSort.DiGraph diGraph, int node, boolean[] visited, boolean[] onStack) {
        boolean hasCycle = false;
        visited[node] = true;
        onStack[node] = true;

        for (int v : diGraph.getAdj(node)) {
            if(!visited[v]) {
                hasCycle =  dfs(diGraph, v, visited, onStack);
            } else if (onStack[v]) {
                return true;
            }
        }
        onStack[node] = false;
        return hasCycle;
    }

    public static void main(String[] args) {
        TopologicalSort.DiGraph diGraph = TopologicalSort.creteGraph();
        diGraph.addEdge(4, 6);
        System.out.println(hasCycle(diGraph));
    }
}
