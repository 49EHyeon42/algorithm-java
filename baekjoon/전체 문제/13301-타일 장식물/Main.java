import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static long solution(int N) {
        if (N == 1) {
            return 4;
        }

        long[] dp = new long[N];
        dp[0] = 4;
        dp[1] = 6;

        for (int i = 2; i < N; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        return dp[N - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(Long.toString((solution(Integer.parseInt(br.readLine())))));
        bw.flush();

        br.close();
        bw.close();
    }
}
