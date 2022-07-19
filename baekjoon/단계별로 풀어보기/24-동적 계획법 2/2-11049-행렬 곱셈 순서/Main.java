import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] matrix = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i < N; i++) {
            for (int j = 1; i + j <= N; j++) {
                dp[j][i + j] = INF;
                for (int k = j; k <= i + j - 1; k++) {
                    dp[j][i + j] = Math.min(dp[j][i + j],
                        dp[j][k] + dp[k + 1][i + j]
                            + matrix[j][0] * matrix[k][1] * matrix[i + j][1]);
                }
            }
        }

        bw.write(Integer.toString(dp[1][N]));

        bw.flush();
        bw.close();
    }
}
