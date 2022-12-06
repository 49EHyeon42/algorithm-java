import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o2.getKey().compareTo(o1.getKey());
            }
            return o1.getValue().compareTo(o2.getValue());
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> result = new LinkedList<>();

        while (!pq.isEmpty()) {
            result.add(0, pq.poll().getKey());
        }

        return result;
    }
}
