import java.util.*;

class Solution {

    private final Queue<Integer> q1 = new LinkedList<>();
    private final Queue<Integer> q2 = new LinkedList<>();

    public int solution(int[] queue1, int[] queue2) {
        int size = queue1.length;

        long sum = 0;
        long q1Sum = 0;
        long q2Sum = 0;

        int q1Max = -1;
        int q2Max = -1;

        for (int i = 0; i < size; i++) {
            sum += (queue1[i] + queue2[i]);
            q1Sum += queue1[i];
            q2Sum += queue2[i];

            q1Max = Math.max(q1Max, queue1[i]);
            q2Max = Math.max(q2Max, queue2[i]);

            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }

        if (q1Sum == q2Sum) {
            return 0;
        }

        long half = sum / 2;

        if ((sum & 1) == 1 || q1Max > half || q2Max > half) {
            return -1;
        }

        int count = 0;

        int maxLoop = size * 10;

        while (maxLoop-- > 0) {
            if (q1Sum < q2Sum) {
                int i = q2.poll();
                q2Sum -= i;
                q1.offer(i);
                q1Sum += i;
            } else if (q1Sum > q2Sum) {
                int i = q1.poll();
                q1Sum -= i;
                q2.offer(i);
                q2Sum += i;
            } else {
                return count;
            }

            count++;
        }

        return -1;
    }
}
