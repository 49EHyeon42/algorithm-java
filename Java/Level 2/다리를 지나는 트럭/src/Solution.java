import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();

        int index = 0;
        int currentBridgeWeight = 0;

        while (index != truck_weights.length) {
            int currentTruckWeight = truck_weights[index];

            if (!queue.isEmpty() && queue.size() == bridge_length) {
                currentBridgeWeight -= queue.poll();
            }

            if (currentBridgeWeight + currentTruckWeight <= weight) {
                currentBridgeWeight += currentTruckWeight;

                queue.offer(currentTruckWeight);

                index++;
            } else {
                queue.offer(0);
            }

            answer++;
        }

        return answer + bridge_length;
    }
}
