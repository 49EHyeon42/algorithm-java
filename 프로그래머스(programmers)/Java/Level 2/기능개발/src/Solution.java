import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int[] solution(int[] progresses, int[] speeds) {
        if (progresses.length == 1) {
            return new int[]{1};
        }

        Queue<Integer> queue = new LinkedList<>();

        int currentDay = getDay(progresses[0], speeds[0]);

        int count = 1;
        for (int i = 1; i < progresses.length; i++) {
            int nextDay = getDay(progresses[i], speeds[i]);

            if (currentDay < nextDay) {
                queue.offer(count);

                currentDay = nextDay;

                count = 1;
            } else {
                count++;
            }

            if (i == progresses.length - 1) {
                queue.offer(count);
            }
        }

        return queue.stream().mapToInt(i -> i).toArray();
    }

    private int getDay(double progress, double speed) {
        return (int) Math.ceil((100 - progress) / speed);
    }
}
