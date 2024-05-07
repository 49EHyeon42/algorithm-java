import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        long[][] dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int move = map[i][j];

                if (move == 0 || dp[i][j] == 0) {
                    continue;
                }

                if (i + move < N) {
                    dp[i + move][j] += dp[i][j];
                }

                if (j + move < N) {
                    dp[i][j + move] += dp[i][j];
                }
            }
        }

        bw.write(Long.toString(dp[N - 1][N - 1]));
        bw.flush();

        br.close();
        bw.close();
    }
}
