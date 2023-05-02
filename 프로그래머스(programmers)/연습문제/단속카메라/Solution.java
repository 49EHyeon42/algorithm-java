import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));

        int count = 0;

        int temp = -30001;

        for (int[] route : routes) {
            if (temp < route[0]) {
                temp = route[1];
                count++;
            }
        }

        return count;
    }
}
