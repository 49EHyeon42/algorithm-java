import java.util.HashMap;

public class Solution {

    public int solution(String word) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        initHashMap(hashMap);

        int[] numberByIndex = new int[]{781, 156, 31, 6, 1};

        int answer = word.length();

        for (int i = 0; i < word.length(); i++) {
            answer += numberByIndex[i] * hashMap.get(word.charAt(i));
        }

        return answer;
    }

    private void initHashMap(HashMap<Character, Integer> hashMap) {
        hashMap.put('A', 0);
        hashMap.put('E', 1);
        hashMap.put('I', 2);
        hashMap.put('O', 3);
        hashMap.put('U', 4);
    }
}
