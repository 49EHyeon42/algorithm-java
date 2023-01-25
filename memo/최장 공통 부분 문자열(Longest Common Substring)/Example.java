import java.util.Arrays;

public class Example {

    public static void main(String[] args) {
        String string1 = "ABCDEF";
        String string2 = "GBCDFE";

        int[][] dp = new int[string1.length() + 1][string2.length() + 1];

        for (int i = 1; i <= string1.length(); i++) {
            for (int j = 1; j <= string2.length(); j++) {
                if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }

        printDP(dp);
    }

    private static void printDP(int[][] dp) {
        System.out.println("=====Print DP=====");
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
