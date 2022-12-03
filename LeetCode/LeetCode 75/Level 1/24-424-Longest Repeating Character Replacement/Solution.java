class Solution {

    public int characterReplacement(String s, int k) {
        int result = 0;

        int[] count = new int[26];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, ++count[s.charAt(i) - 'A']);

            if (result - max < k) {
                result++;
            } else {
                count[s.charAt(i - result) - 'A']--;
            }
        }

        return result;
    }
}
