import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] array = new int[N][2]; // [0] = 시간, [1] = 배점
        int[][] dp = new int[N + 1][T + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }

        // dp[시험][시간] = 시험과 시간 대비 최대 배점

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= T; j++) {
                dp[i][j] = array[i - 1][0] <= j ?
                        Math.max(dp[i - 1][j], array[i - 1][1] + dp[i - 1][j - array[i - 1][0]])
                        : dp[i - 1][j];
            }
        }

        bw.write(Integer.toString(dp[N][T]));
        bw.flush();

        br.close();
        bw.close();
    }
}
