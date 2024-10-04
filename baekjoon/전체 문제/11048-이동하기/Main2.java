import java.io.*;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] array = new int[N][M];
        int[][] dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());

                if (i == 0 && j == 0) {
                    dp[0][0] = array[0][0];
                } else if (i == 0) {
                    dp[0][j] = dp[0][j - 1] + array[0][j];
                } else if (j == 0) {
                    dp[i][0] = dp[i - 1][0] + array[i][0];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + array[i][j];
                }
            }
        }

        bw.write(Integer.toString(dp[N - 1][M - 1]));
        bw.flush();

        br.close();
        bw.close();
    }
}
