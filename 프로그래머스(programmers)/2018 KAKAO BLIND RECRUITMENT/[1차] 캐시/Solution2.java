import java.util.*;

// Solution1 중 miss 최적화
class Solution {

    private final Deque<String> cache = new LinkedList<>();

    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        int runningTime = 0;

        for (String city : cities) {
            city = city.toLowerCase();

            if (cache.contains(city)) {
                cache.remove(city);
                cache.offerLast(city);

                // hit
                runningTime++;

                continue;
            }

            if (cache.size() >= cacheSize) {
                cache.pollFirst();
            }

            cache.offerLast(city);

            // miss
            runningTime += 5;
        }

        return runningTime;
    }
}
