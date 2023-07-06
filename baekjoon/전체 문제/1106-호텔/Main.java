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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] dp = new int[C + 100];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int guest = Integer.parseInt(st.nextToken());

            for (int j = guest; j < C + 100; j++) {
                if (dp[j - guest] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], cost + dp[j - guest]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = C; i < C + 100; i++) {
            min = Integer.min(min, dp[i]);
        }

        bw.write(Integer.toString(min));
        bw.flush();

        br.close();
        bw.close();
    }
}
