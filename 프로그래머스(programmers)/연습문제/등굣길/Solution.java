// 집에서 학교의 최단 거리가 없는 경우 -> return 0

public class Solution {

    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];

        dp[2][1] = dp[1][2] = 1;

        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if ((i == 1 && j == 1) || (i == 2 && j == 1) || (i == 1 && j == 2)) {
                    continue;
                }

                if (isPuddle(dp[i][j])) {
                    continue;
                }

                dp[i][j] = ((isPuddle(dp[i - 1][j]) ? 0 : dp[i - 1][j]) +
                        (isPuddle(dp[i][j - 1]) ? 0 : dp[i][j - 1])) % 1000000007;
            }
        }

        return dp[n][m];
    }

    private boolean isPuddle(int i) {
        return i == -1;
    }
}
