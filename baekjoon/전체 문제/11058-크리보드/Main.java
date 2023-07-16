import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static long solution(int N) {
        if (N < 7) {
            return N;
        }

        long[] dp = new long[N + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        dp[5] = 5;
        dp[6] = 6;

        for (int i = 7; i <= N; i++) {
            for (int j = 3; i - j > 0; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] * (j - 1));
            }
        }

        return dp[N];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(Long.toString(solution(Integer.parseInt(br.readLine()))));
        bw.flush();

        br.close();
        bw.close();
    }
}
