import java.util.Arrays;

public class Solution {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        if (costs[0] > coins) {
            return 0;
        }

        int count = 0;
        int sum = 0;

        for (int cost : costs) {
            if (sum + cost > coins) {
                break;
            }

            count++;
            sum += cost;
        }

        return count;
    }
}
