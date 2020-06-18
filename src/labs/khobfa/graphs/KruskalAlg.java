package labs.khobfa.graphs;

import labs.khobfa.union.QuickUnionOpt;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KruskalAlg {

    double weight = 0;
    Queue<Edge> mst = new LinkedList<>();

    void findMinimumSpanningTree(WeightedGraph graph) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(graph.getEdges());
        QuickUnionOpt unionOpt = new QuickUnionOpt(graph.vertices);

        while (!priorityQueue.isEmpty() && mst.size() != graph.vertices - 1) {
            Edge edge = priorityQueue.remove();
            int v = edge.either(), w = edge.other(v);

            if (!unionOpt.isConnected(v, w)) {
                mst.add(edge);
                unionOpt.union(v, w);
                weight += edge.getWeight();
            }
        }
    }

    public double minWeight() {
        return weight;
    }

    Iterable<Edge> getEdges() {
        return mst;
    }

    public static class WeightedGraph {
        int vertices, totalEdges;
        LinkedList<Edge>[] adjacent;
        Queue<Edge> edges;

        public WeightedGraph(int vertices) {
            this.vertices = vertices;
            this.adjacent = new LinkedList[vertices];
            edges = new LinkedList<>();
            for(int i = 0; i < vertices; i++) {
                adjacent[i] = new LinkedList<>();
            }
        }

        public void addEdge(Edge e) {
            int v = e.either(), w = e.other(v);
            adjacent[v].add(e);
            adjacent[w].add(e);
            edges.add(e);
            totalEdges++;
        }

        public Iterable<Edge> getAdj(int v) {
            return adjacent[v];
        }

        public int getVertices() {
            return vertices;
        }

        public int getTotalEdges() {
            return totalEdges;
        }

        public Queue<Edge> getEdges() {
            return edges;
        }
    }

    static class Edge implements Comparable<Edge> {
        private final int v;
        private final int w;
        private final double weight;

        public Edge(int v, int w, double weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }

        public int either() {
            return v;
        }

        public int other(int v) {
            if(this.v == v) return w;
            else return v;
        }

        public double getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Edge e) {
            return Double.compare(this.weight, e.weight);
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "v=" + v +
                    ", w=" + w +
                    ", weight=" + weight +
                    '}';
        }
    }

    static WeightedGraph createGraph() {
        WeightedGraph graph = new WeightedGraph(8);
        graph.addEdge(new Edge(0, 1, 4));
        graph.addEdge(new Edge(0, 3, 6));
        graph.addEdge(new Edge(0, 2, 16));
        graph.addEdge(new Edge(2, 3, 8));
        graph.addEdge(new Edge(2, 4, 10));
        graph.addEdge(new Edge(2, 7, 21));
        graph.addEdge(new Edge(3, 4, 5));
        graph.addEdge(new Edge(3, 5, 23));
        graph.addEdge(new Edge(1, 5, 24));
        graph.addEdge(new Edge(4, 5, 18));
        graph.addEdge(new Edge(4, 6, 11));
        graph.addEdge(new Edge(4, 7, 14));
        graph.addEdge(new Edge(6, 7, 7));
        graph.addEdge(new Edge(6, 5, 9));
        graph.addEdge(new Edge(7, 5, 13));

        return graph;
    }

    public static void main(String[] args) {
        KruskalAlg alg = new KruskalAlg();
        alg.findMinimumSpanningTree(createGraph());
        System.out.println("weight " + alg.weight);
        alg.getEdges().forEach(System.out::println);
    }
}
