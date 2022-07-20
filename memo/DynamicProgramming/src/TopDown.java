public class TopDown {

    private int MAX_SIZE = 10;

    private int[] dp = new int[MAX_SIZE + 1];

    public int ExampleFibonacci(int number) {
        if (number <= 1) {
            return number;
        } else if (dp[number] != 0) {
            return dp[number];
        } else {
            return dp[number] = ExampleFibonacci(number - 1)
                + ExampleFibonacci(number - 2);
        }
    }
}
