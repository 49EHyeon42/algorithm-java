class Solution {

    // Time complexity = O(N), Space complexity = O(N)
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // Time complexity = O(N), Space complexity = O(1)
    public int climbStairs2(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        int temp1 = 1;
        int temp2 = 2;

        while (n-- > 2) {
            int sum = temp1 + temp2;
            temp1 = temp2;
            temp2 = sum;
        }

        return temp2;
    }
}
