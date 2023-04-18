public class Solution {

    public boolean solution(String string) {
        char[] chars = string.toCharArray();

        int difference = 0;

        for (char c : chars) {
            if (c == 'P' || c == 'p') {
                difference++;
            } else if (c == 'Y' || c == 'y') {
                difference--;
            }
        }

        return difference == 0;
    }
}
