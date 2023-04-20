public class Solution {

    public int solution(String string) {
        char[] chars = string.toCharArray();

        int count = 0;

        Character x = null;
        int tempCount = 1;

        for (char c : chars) {
            if (x == null) {
                x = c;
                continue;
            }

            if (c == x) {
                tempCount++;
            } else {
                tempCount--;
            }

            if (tempCount == 0) {
                count++;
                x = null;
                tempCount = 1;
            }
        }

        if (x != null) {
            count++;
        }

        return count;
    }
}
