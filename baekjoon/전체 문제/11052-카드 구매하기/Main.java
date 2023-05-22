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

        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        dp[1] = array[0];

        for (int i = 2; i <= N; i++) {
            int max = array[i - 1];

            for (int j = 1; j < i; j++) {
                max = Math.max(max, dp[i - j] + array[j - 1]);
            }

            dp[i] = max;
        }

        bw.write(Integer.toString(dp[N]));
        bw.flush();

        br.close();
        bw.close();
    }
}
