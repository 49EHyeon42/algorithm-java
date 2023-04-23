public class Solution {

    public int solution(int[][] land) {
        int[][] dp = new int[land.length][land[0].length];

        System.arraycopy(land[0], 0, dp[0], 0, land[0].length);

        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                for (int k = 0; k < land[i].length; k++) {
                    if (j == k) {
                        continue;
                    }
                    
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + land[i][j]);
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < land[0].length; i++) {
            answer = Math.max(answer, dp[land.length - 1][i]);
        }

        return answer;
    }
}
