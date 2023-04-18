import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    public int[] solution(String[] operations) {
        DoubleEndedPriorityQueue depq = new DoubleEndedPriorityQueue(operations.length);

        for (int i = 0; i < operations.length; i++) {
            StringTokenizer st = new StringTokenizer(operations[i]);
            String command = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            if (command.equals("I")) {
                depq.add(value, i);
            } else { // command = D
                if (value == 1) {
                    depq.removeMax();
                } else { // value == -1
                    depq.removeMin();
                }
            }
        }

        return depq.getAnswer();
    }

    private static class DoubleEndedPriorityQueue {

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

        public int[] getAnswer() {
            while (!maxHeap.isEmpty() && !isVisited[maxHeap.peek().getIndex()]) {
                maxHeap.poll();
            }
            while (!minHeap.isEmpty() && !isVisited[minHeap.peek().getIndex()]) {
                minHeap.poll();
            }

            int max = (!maxHeap.isEmpty()) ? maxHeap.poll().getValue() : 0;
            int min = (!minHeap.isEmpty()) ? minHeap.poll().getValue() : 0;

            return new int[]{max, min};
        }
    }

    private static class Node implements Comparable<Node> {

        private final int value;
        private final int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.value, o.value);
        }
    }
}
