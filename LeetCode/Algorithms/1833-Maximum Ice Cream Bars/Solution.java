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

    public int maxIceCream2(int[] costs, int coins) {
        // Store ice cream costs in increasing order.
        Arrays.sort(costs);

        int n = costs.length;
        int icecream = 0;

        // Pick ice creams till we can.
        while (icecream < n && costs[icecream] <= coins) {
            // We can buy this icecream, reduce the cost from the coins. 
            coins -= costs[icecream];
            icecream += 1;
        }

        return icecream;
    }
}
