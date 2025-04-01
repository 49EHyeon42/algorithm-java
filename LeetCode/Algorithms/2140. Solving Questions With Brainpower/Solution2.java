class Solution {

    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];

        return backtracking(questions, dp, 0);
    }

    public long backtracking(int[][] questions, long[] dp, int index) {
        if (index >= questions.length) {
            return 0;
        }

        if (dp[index] != 0) {
            return dp[index];
        }

        dp[index] = Math.max(
                // 1. 문제를 푸는 경우
                questions[index][0] + backtracking(questions, dp, index + questions[index][1] + 1),
                // 2. 문제를 넘어가는 경우
                backtracking(questions, dp, index + 1));

        return dp[index];
    }
}
