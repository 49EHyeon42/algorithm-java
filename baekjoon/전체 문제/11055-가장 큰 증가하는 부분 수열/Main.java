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

        int[] array = new int[N + 1];
        int[] dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            array[i] = dp[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (array[i] > array[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + array[i]);
                }
            }

            max = Math.max(max, dp[i]);
        }

        bw.write(Integer.toString(max));
        bw.flush();

        br.close();
        bw.close();
    }
}
