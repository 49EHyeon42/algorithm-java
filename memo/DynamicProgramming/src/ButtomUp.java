public class ButtomUp {

    private int MAX_SIZE = 10;

    private int[] dp = new int[MAX_SIZE + 1];

    public int ExampleFibonacci(int number) {
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= number; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[number];
    }
}
