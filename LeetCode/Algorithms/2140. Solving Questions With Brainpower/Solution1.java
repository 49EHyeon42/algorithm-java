// 시간 초과
class Solution {

    public long mostPoints(int[][] questions) {
        return backtracking(questions, 0);
    }

    public long backtracking(int[][] questions, int index) {
        if (index >= questions.length) {
            return 0;
        }

        return Math.max(
                // 1. 문제를 푸는 경우
                questions[index][0] + backtracking(questions, index + questions[index][1] + 1),
                // 2. 문제를 넘어가는 경우
                backtracking(questions, index + 1));
    }
}
