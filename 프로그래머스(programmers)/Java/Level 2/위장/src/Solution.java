import java.util.HashMap;

public class Solution {

    public int solution(String[][] clothes) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String[] row : clothes) {
            String key = row[1];
            hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
        }

        int count = 1;
        for (String key : hashMap.keySet()) {
            count *= hashMap.get(key) + 1;
        }

        return count - 1;
    }
}
