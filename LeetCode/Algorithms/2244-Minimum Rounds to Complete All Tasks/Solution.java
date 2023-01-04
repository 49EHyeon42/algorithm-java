import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        if (map.containsValue(1)) {
            return -1;
        }

        int minimumRounds = 0;

        for (int i : map.values()) {
            minimumRounds += (i % 3 == 0) ? i / 3 : i / 3 + 1;
        }

        return minimumRounds;
    }
}
