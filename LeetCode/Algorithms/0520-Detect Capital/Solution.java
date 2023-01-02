public class Solution {

    public boolean detectCapitalUse(String word) {
        if (word.equals(word.toUpperCase()) || word.equals(word.toLowerCase())) {
            return true;
        }

        for (int i = 1; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public boolean detectCapitalUse2(String word) {
        return word.matches("[A-Z]*|.[a-z]*");
    }
}
