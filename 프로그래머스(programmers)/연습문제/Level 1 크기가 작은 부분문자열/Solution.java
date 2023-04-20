public class Solution {

    public int solution(String t, String p) {
        int count = 0;
        
        long pNumber = Long.parseLong(p);

        for (int i = 0; i < t.length() - p.length() + 1; i++) {
            if (pNumber >= Long.parseLong(t.substring(i, i + p.length()))) {
                count++;
            }
        }

        return count;
    }
}
