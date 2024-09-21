import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        bw.write(Integer.toString(dp(N)));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int dp(int sugar) {
        if (sugar <= 5) {
            return sugar == 3 || sugar == 5 ? 1 : -1;
        }

        // dp = 최소 봉지 수
        int[] dp = new int[sugar + 1];

        for (int i = 1; i <= sugar; i++) {
            // 3 <= N <= 5000
            dp[i] = 5001;
        }

        dp[3] = 1;
        dp[5] = 1;

        for (int i = 6; i <= sugar; i++) {
            dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
        }

        // MAX = 5002
        return dp[sugar] != 5002 ? dp[sugar] : -1;
    }
}
