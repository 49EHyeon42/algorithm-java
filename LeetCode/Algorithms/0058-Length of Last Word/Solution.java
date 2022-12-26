public class Solution {

    public int lengthOfLastWord(String s) {
        s = s.trim();
        return s.length() - s.lastIndexOf(' ') - 1;
    }
    
    public int lengthOfLastWord2(String s) {
        int result = 0;
        int i = s.length() - 1;

        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        while (i >= 0 && s.charAt(i) != ' ') {
            result++;
            i--;
        }

        return result;
    }
}
