import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    // reference
    // https://blog.naver.com/hands731/221806277981

    private static int solution(int N) {
        if (N % 2 == 1) {
            return 0;
        }

        int[] dp = new int[N + 1];

        dp[0] = 1;
        dp[2] = 3;

        for (int i = 4; i <= N; i++) {
            dp[i] = dp[i - 2] * dp[2];

            for (int j = 4; j < i; j += 2) {
                dp[i] += 2 * dp[i - j];
            }

            dp[i] += 2;
        }

        return dp[N];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(Integer.toString(solution(Integer.parseInt(br.readLine()))));
        bw.flush();

        br.close();
        bw.close();
    }
}
