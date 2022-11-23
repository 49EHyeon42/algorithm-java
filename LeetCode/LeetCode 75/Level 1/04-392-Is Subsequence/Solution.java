class Solution {

    public boolean isSubsequence(String s, String t) {
        int indexS = 0;

        for (int indexT = 0; indexT < t.length() && indexS < s.length(); indexT++) {
            if (s.charAt(indexS) == t.charAt(indexT)) {
                indexS++;
            }
        }

        return indexS == s.length();
    }
}
