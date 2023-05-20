import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static String dp(int N) {
        if (N < 6) {
            return N != 2 ? "SK" : "CY";
        }

        boolean[] dp = new boolean[N + 1];
        dp[1] = dp[3] = dp[4] = dp[5] = true;

        for (int i = 6; i <= N; i++) {
            dp[i] = !(dp[i - 1] && dp[i - 3] && dp[i - 4]);
        }

        return dp[N] ? "SK" : "CY";
    }

    // reference : https://steady-coding.tistory.com/168
    private static String anotherSolution(int N) {
        return (N % 7 != 0 && N % 7 != 2) ? "SK" : "CY";
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
