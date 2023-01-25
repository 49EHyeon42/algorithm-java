import java.util.Arrays;

public class Example {

    // 시간 복잡도 = O(string1.length() * string2.length())

    public static void main(String[] args) {
        String string1 = "ABCDEF";
        String string2 = "GBCDFE";

        int[][] dp = new int[string1.length() + 1][string2.length() + 1];

        int maxLength = Integer.MIN_VALUE;

        for (int i = 1; i <= string1.length(); i++) {
            for (int j = 1; j <= string2.length(); j++) {
                if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

                if (maxLength < dp[i][j]) {
                    maxLength = dp[i][j];
                }
            }
        }

        printDP(dp);

        System.out.println("maxLength = " + maxLength);

        System.out.println("Max Subsequence = " + getMaxSubsequence(dp,
                string1, string2,
                string1.length(), string2.length()));
    }

    private static void printDP(int[][] dp) {
        System.out.println("=====Print DP=====");
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
    }

    // Backtracking
    private static String getMaxSubsequence(int[][] dp,
            String string1, String string2,
            int i, int j) {
        if (i == 0 || j == 0) {
            return "";
        } else if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
            return getMaxSubsequence(dp, string1, string2, i - 1, j - 1) + string1.charAt(i - 1);
        }

        if (dp[i][j - 1] < dp[i - 1][j]) {
            return getMaxSubsequence(dp, string1, string2, i - 1, j);
        }
        return getMaxSubsequence(dp, string1, string2, i, j - 1);
    }
}
