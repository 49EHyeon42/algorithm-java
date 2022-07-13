import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// two-way : sequential search, priority queue
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bw.write(Integer.toString(dijkstra(N, K)));

        bw.flush();
        bw.close();
    }

    private static int dijkstra(int n, int k) {
        int MAX_SIZE = 100000;

        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        boolean[] isVisited = new boolean[MAX_SIZE + 1];

        priorityQueue.offer(new Vertex(n, 0));

        while (!priorityQueue.isEmpty()) {
            int currentValue = priorityQueue.peek().getValue();
            int currentWeight = priorityQueue.peek().getWeight();
            priorityQueue.poll();

            isVisited[currentValue] = true;

            if (currentValue == k) {
                return currentWeight;
            }

            if (currentValue * 2 <= MAX_SIZE && !isVisited[currentValue * 2]) {
                priorityQueue.offer(new Vertex(currentValue * 2, currentWeight));
            }
            if (currentValue + 1 <= MAX_SIZE && !isVisited[currentValue + 1]) {
                priorityQueue.offer(new Vertex(currentValue + 1, currentWeight + 1));
            }
            if (currentValue - 1 >= 0 && !isVisited[currentValue - 1]) {
                priorityQueue.offer(new Vertex(currentValue - 1, currentWeight + 1));
            }
        }

        return -1;
    }

    private static class Vertex implements Comparable<Vertex> {

        private final int value;
        private final int weight;

        public Vertex(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }

        public int getValue() {
            return value;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.weight - o.weight;
        }
    }
}
