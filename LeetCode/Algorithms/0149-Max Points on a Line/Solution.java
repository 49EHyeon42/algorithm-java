import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// official solution : https://leetcode.com/problems/max-points-on-a-line/solutions/2910679/max-points-on-a-line/?orderBy=most_votes
// time complexity : O(N^2)
// space complexity : O(N)
public class Solution {

    public int maxPoints(int[][] points) {
        if (points.length == 1) {
            return 1;
        }

        int maxPoint = 2;

        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> map = new HashMap<>();

            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    map.merge(Math.atan2(points[j][1] - points[i][1], points[j][0] - points[i][0]),
                            1, Integer::sum);
                }
            }

            maxPoint = Math.max(maxPoint, Collections.max(map.values()) + 1);
        }

        return maxPoint;
    }
}
