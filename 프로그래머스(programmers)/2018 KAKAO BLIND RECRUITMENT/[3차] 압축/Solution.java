import java.util.*;

class Solution {

    private final Map<String, Integer> dictionary = new HashMap<>();

    public int[] solution(String msg) {
        initDictionary();

        List<Integer> result = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        int sequence = 27;

        int i = 0;

        while (i < msg.length()) {
            if (dictionary.containsKey(sb.toString() + msg.charAt(i))) {
                sb.append(msg.charAt(i++));

                continue;
            }

            String string = sb.toString();

            sb.setLength(0);

            dictionary.put(string + msg.charAt(i), sequence++);

            result.add(dictionary.get(string));
        }

        // 마지막 추가
        if (sb.length() != 0) {
            result.add(dictionary.get(sb.toString()));
        }

        return result.stream().mapToInt(j -> j).toArray();
    }

    private void initDictionary() {
        for (int i = 0; i < 26; i++) {
            dictionary.put(String.valueOf((char) ('A' + i)), i + 1);
        }
    }
}
