import java.util.PriorityQueue;

public class Solution {

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i : scoville) {
            minHeap.offer(i);
        }

        int count = 0;
        while (minHeap.size() > 1 && minHeap.peek() < K) {
            int firstFood = minHeap.poll();
            int secondFood = minHeap.poll();

            minHeap.offer(firstFood + (secondFood * 2));

            count++;
        }

        if (minHeap.peek() < K) {
            return -1;
        }
        return count;
    }
}
