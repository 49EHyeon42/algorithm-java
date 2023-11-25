import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            long sum = 0;

            for (int j = 0, k = i - 1; j < i / 2; j++, k--) {
                sum += 2 * dp[j] * dp[k];
            }

            if ((i & 1) == 1) {
                sum += dp[i / 2] * dp[i / 2];
            }

            dp[i] = sum;
        }

        bw.write(Long.toString(dp[n]));
        bw.flush();

        br.close();
        bw.close();
    }
}
