public class Solution {

    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[]{-1};
        }

        int[] answer = new int[n];

        int quotient = s / n;

        int length = n - s % n;

        for (int i = 0; i < length; i++) {
            answer[i] = quotient;
        }

        for (int i = length; i < n; i++) {
            answer[i] = quotient + 1;
        }

        return answer;
    }
}
