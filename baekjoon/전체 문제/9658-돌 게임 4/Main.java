import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static String dp(int N) {
        if (N < 5) {
            return N == 2 || N == 4 ? "SK" : "CY";
        }

        boolean[] dp = new boolean[N + 1];
        dp[2] = dp[4] = true;

        for (int i = 5; i <= N; i++) {
            dp[i] = !(dp[i - 1] && dp[i - 3] && dp[i - 4]);
        }

        return dp[N] ? "SK" : "CY";
    }

    private static String anotherSolution(int N) {
        return (N % 7 != 1 && N % 7 != 3) ? "SK" : "CY";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(dp(Integer.parseInt(br.readLine())));
        bw.flush();

        br.close();
        bw.close();
    }
}
