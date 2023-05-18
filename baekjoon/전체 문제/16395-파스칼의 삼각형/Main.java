import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static long solution(int n, int k) {
        if (n == 1 || n == 2) { // n == 2 없어도 됨
            return 1;
        }

        int[][] dp = new int[n + 1][n + 1];
        dp[1][1] = dp[2][1] = dp[2][2] = 1;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = j == 1 || j == i ? 1 : dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        return dp[n][k];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bw.write(Long.toString((solution(n, k))));
        bw.flush();

        br.close();
        bw.close();
    }
}
