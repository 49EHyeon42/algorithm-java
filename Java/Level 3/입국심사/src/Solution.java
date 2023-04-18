import java.util.Arrays;

public class Solution {

    public long solution(int n, int[] times) {
        long low = 1;
        long high = (long) Arrays.stream(times).max().getAsInt() * n;

        while (low <= high) {
            long mid = (low + high) / 2;

            long sum = 0;
            for (int time : times) {
                sum += mid / time;
            }

            if (n <= sum) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
