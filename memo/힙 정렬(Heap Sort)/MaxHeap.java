public class MaxHeap {

    private final int[] heap;
    private int currentSize;

    public MaxHeap(int maxSize) {
        this.heap = new int[maxSize + 1];
    }

    public void push(int node) {
        if (currentSize == heap.length - 1) {
            throw new IllegalStateException();
        }

        heap[++currentSize] = node;

        int child = currentSize;
        int parent = child / 2;

        while (child > 1 && heap[child] > heap[parent]) {
            // swap
            int temp = heap[child];
            heap[child] = heap[parent];
            heap[parent] = temp;

            child = parent;
            parent = child / 2;
        }
    }

    public int pop() {
        if (currentSize == 0) {
            throw new IllegalStateException();
        }

        int pop = heap[1];

        // swap
        int temp = heap[1];
        heap[1] = heap[currentSize];
        heap[currentSize] = temp;

        currentSize -= 1;

        int parent = 1;
        int child = parent * 2;

        if (child + 1 <= currentSize) {
            child = (heap[child] > heap[child + 1]) ? child : child + 1;
        }

        while (child <= currentSize && heap[child] > heap[parent]) {
            temp = heap[child];
            heap[child] = heap[parent];
            heap[parent] = temp;

            parent = child;
            child = parent * 2;

            if (child + 1 <= currentSize) {
                child = (heap[child] > heap[child + 1]) ? child : child + 1;
            }
        }

        return pop;
    }
}
