package labs.khobfa.union;

public class QuickUnionOpt {
    private final int[] weight;
    private final int[] ids;

    public QuickUnionOpt(int vertices) {
        this.weight = new int[vertices];
        this.ids = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            ids[i] = i;
            weight[i] = 1;
        }
    }

    public void union(int v, int w) {
        int vRoot = findRoot(v);
        int wRoot = findRoot(w);

        if(vRoot > wRoot) {
            ids[vRoot] = wRoot;
            weight[wRoot] = weight[wRoot]++;
        } else {
            ids[vRoot] = wRoot;
            weight[vRoot] = weight[vRoot]++;
        }
    }

    private int findRoot(int v) {
        while (v != ids[v]) v = ids[v];
        return v;
    }

    public boolean isConnected(int v, int w) {
        return findRoot(v) == findRoot(w);
    }
}
