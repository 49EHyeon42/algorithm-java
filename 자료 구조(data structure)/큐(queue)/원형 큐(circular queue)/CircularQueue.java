public class CircularQueue {

    private int[] array;
    private int front;
    private int rear;

    public CircularQueue(int maxSize) {
        array = new int[maxSize + 1];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % array.length == front;
    }

    public void enqueue(int i) {
        if (isFull()) {
            throw new IllegalStateException("The queue is full.");
        }

        rear = ++rear % array.length;
        array[rear] = i;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("The queue is empty.");
        }

        front = ++front % array.length;

        return array[front];
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("The queue is empty.");
        }

        return array[(front + 1) % array.length];
    }
}
