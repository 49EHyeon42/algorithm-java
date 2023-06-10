import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];
        int[][] dp = new int[n][2];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int max = dp[0][0] = dp[0][1] = array[0];

        for (int i = 1; i < n; i++) {
            // 제거하지 않았을 때 가장 큰 값
            dp[i][0] = Math.max(dp[i - 1][0] + array[i], array[i]);
            // 수열에서 1개를 제거 했을 때 가장 큰 값
            // dp[i - 1][0] = 제거하지 않았을 때 가장 큰 값
            // dp[i - 1][1] + array[i] = 제거한 큰 수 + 값
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + array[i]);

            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }

        bw.write(Integer.toString(max));
        bw.flush();

        br.close();
        bw.close();
    }
}
