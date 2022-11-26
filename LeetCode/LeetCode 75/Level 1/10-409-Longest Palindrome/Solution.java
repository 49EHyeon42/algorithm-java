class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char character : s.toCharArray()) {
            map.put(character, map.getOrDefault(character, 0) + 1);
        }

        int length = 0;
        for (Integer value : map.values()) {
            length += (value % 2 == 0) ? value : value - 1;
        }

        return length + ((length < s.length()) ? 1 : 0);
    }
}
