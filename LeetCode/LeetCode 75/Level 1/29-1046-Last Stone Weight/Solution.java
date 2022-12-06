import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int stone : stones) {
            pq.add(stone);
        }

        while (pq.size() > 1) {
            int firstStone = pq.poll();
            int secondStone = pq.poll();

            if (firstStone - secondStone != 0) {
                pq.add(firstStone - secondStone);
            }
        }

        return (pq.size() == 1) ? pq.poll() : 0;
    }
}
