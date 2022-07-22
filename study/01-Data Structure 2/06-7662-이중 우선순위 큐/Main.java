import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int commandNumber = Integer.parseInt(br.readLine());

            DoubleEndedPriorityQueue depq = new DoubleEndedPriorityQueue(commandNumber);

            for (int j = 0; j < commandNumber; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                if (st.nextToken().equals("I")) {
                    depq.add(Integer.parseInt(st.nextToken()), j);
                } else {
                    if (st.nextToken().equals("1")) {
                        depq.removeMax();
                    } else {
                        depq.removeMin();
                    }
                }
            }

            sb.append(depq.answer());
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    public static class DoubleEndedPriorityQueue {

        private final PriorityQueue<Node> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        private final PriorityQueue<Node> minHeap = new PriorityQueue<>();
        private final boolean[] isVisited;

        public DoubleEndedPriorityQueue(int commandNumber) {
            isVisited = new boolean[commandNumber];
        }

        public void add(int value, int index) {
            maxHeap.offer(new Node(value, index));
            minHeap.offer(new Node(value, index));
            isVisited[index] = true;
        }

        public void removeMax() {
            while (!maxHeap.isEmpty() && !isVisited[maxHeap.peek().getIndex()]) {
                maxHeap.poll();
            }
            if (!maxHeap.isEmpty()) {
                isVisited[maxHeap.peek().getIndex()] = false;
                maxHeap.poll();
            }
        }

        public void removeMin() {
            while (!minHeap.isEmpty() && !isVisited[minHeap.peek().getIndex()]) {
                minHeap.poll();
            }
            if (!minHeap.isEmpty()) {
                isVisited[minHeap.peek().getIndex()] = false;
                minHeap.poll();
            }
        }

        public String answer() {
            while (!maxHeap.isEmpty() && !isVisited[maxHeap.peek().getIndex()]) {
                maxHeap.poll();
            }
            while (!minHeap.isEmpty() && !isVisited[minHeap.peek().getIndex()]) {
                minHeap.poll();
            }

            if (maxHeap.isEmpty() && minHeap.isEmpty()) {
                return "EMPTY\n";
            }
            return maxHeap.peek().getValue() + " " + minHeap.peek().getValue() + "\n";
        }
    }

    public static class Node implements Comparable<Node> {

        private final Long value;
        private final int index;

        public Node(long value, int index) {
            this.value = value;
            this.index = index;
        }

        public Long getValue() {
            return value;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public int compareTo(Node o) {
            return this.value.compareTo(o.value);
        }
    }
}
