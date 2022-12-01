class Solution {

    // Time complexity = O(N), Space complexity = O(N)
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // Time complexity = O(N), Space complexity = O(1)
    public int fib2(int n) {
        if (n <= 1) {
            return n;
        }

        int temp1 = 0;
        int temp2 = 1;

        while (n-- > 1) {
            int sum = temp1 + temp2;
            temp1 = temp2;
            temp2 = sum;
        }

        return temp2;
    }
}
