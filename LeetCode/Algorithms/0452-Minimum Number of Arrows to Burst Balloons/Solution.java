import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(point -> point[1]));

        int count = 0;
        int arrow = Integer.MIN_VALUE;

        for (int[] point : points) {
            if (count == 0 || point[0] > arrow) {
                count++;
                arrow = point[1];
            }
        }

        return count;
    }
}
