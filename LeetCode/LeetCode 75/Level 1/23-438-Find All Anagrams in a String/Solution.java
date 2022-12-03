import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        int[] chars = new int[26];

        for (char character : p.toCharArray()) {
            chars[character - 'a']++;
        }

        for (int end = 0, start = 0; end < s.length(); end++) {
            char character = s.charAt(end);
            chars[character - 'a']--;

            while (chars[character - 'a'] < 0) {
                chars[s.charAt(start) - 'a']++;
                start++;
            }

            if (end - start + 1 == p.length()) {
                result.add(start);
            }
        }
        return result;
    }
}
