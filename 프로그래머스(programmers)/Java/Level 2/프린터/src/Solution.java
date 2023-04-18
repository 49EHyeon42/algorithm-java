import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int priority : priorities) {
            pq.offer(priority);
        }

        int answer = 1;

        loop:
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (!pq.isEmpty() && priorities[i] == pq.peek()) {
                    if (location == i) {
                        break loop;
                    }

                    pq.poll();

                    answer++;
                }
            }
        }

        return answer;
    }
}
