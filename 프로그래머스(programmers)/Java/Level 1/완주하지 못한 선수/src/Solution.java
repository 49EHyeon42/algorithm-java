import java.util.HashMap;

class Solution {

    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        for (String name : participant) {
            hashMap.put(name, hashMap.getOrDefault(name, 0) + 1);
        }
        for (String name : completion) {
            hashMap.put(name, hashMap.getOrDefault(name, 0) - 1);
        }

        for (String name : hashMap.keySet()) {
            if (hashMap.get(name) != 0) {
                return name;
            }
        }
        return "";
    }
}
