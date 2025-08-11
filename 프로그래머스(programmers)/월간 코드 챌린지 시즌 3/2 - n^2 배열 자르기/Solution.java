class Solution {

    public int[] solution(int n, long left, long right) {
        // 예상: value[i][j] = Math.max(i + 1, j + 1);

        // right - left < 10^5 이므로 array의 길이는 항상 int 범위 안에 있다.
        int[] answer = new int[(int) (right - left) + 1];

        int index = 0;

        for (long i = left; i <= right; i++) {
            // quotient는 array[i][j]의 i와 같다.
            long quotient = i / n;
            // remainder는 array[i][j]의 j와 같다.
            long remainder = i % n;

            answer[index++] = (int) Math.max(quotient, remainder) + 1;
        }

        return answer;
    }
}
