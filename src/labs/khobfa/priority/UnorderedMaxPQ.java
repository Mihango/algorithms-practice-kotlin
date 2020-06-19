package labs.khobfa.priority;

public class UnorderedMaxPQ<T extends Comparable<T>> {
    private final T[] queue;
    private int N;

    @SuppressWarnings("unchecked")
    public UnorderedMaxPQ(int capacity) {
        queue = (T[]) new Comparable[capacity];
    }

    public void insert(T item) {
        queue[N++] = item;
    }

    public T delMax() {
        int max = 0;
        for (int i = 0; i < N; i++) {
            if(less(max, i)) max = i;
        }
        swap(max, N-1);
        return queue[--N];
    }

    private boolean less(int i, int j) {
        return queue[i].compareTo(queue[j]) < 0;
    }

    private void swap(int i, int j) {
        T tmp = queue[i];
        queue[i] = queue[j];
        queue[j] = tmp;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void data() {
        for (int i =0; i < N; i++) {
            System.out.print(queue[i] + " ");}
    }

    public static void main(String[] args) {
        UnorderedMaxPQ<Integer> pq = new UnorderedMaxPQ<>(5);
        pq.insert(4);
        pq.insert(2);
        pq.insert(5);
        pq.insert(7);

        System.out.println("Queue size >>> " + pq.size());
        pq.data();

        pq.delMax();
        System.out.println("After del max >>>> Queue size >>> " + pq.size());
        pq.data();
    }
}
