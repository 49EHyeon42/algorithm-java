class Solution {

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (s.length() > t.length()) {
            return false;
        }

        int indexS = 0;
        for (int indexT = 0; indexT < t.length(); indexT++) {
            if (s.charAt(indexS) == t.charAt(indexT)) {
                if (++indexS == s.length()) {
                    return true;
                }
            }
        }
            
        return indexS == s.length();
    }
}
