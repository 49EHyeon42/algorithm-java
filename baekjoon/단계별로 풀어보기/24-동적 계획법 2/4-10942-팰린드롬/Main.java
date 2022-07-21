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
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N + 1];
        boolean[][] dp = new boolean[N + 1][N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(st.nextToken());

            dp[i][i] = true;

            if (i != 1 && array[i - 1] == array[i]) {
                dp[i - 1][i] = true;
            }
        }

        for (int i = 2; i <= N - 1; i++) {
            for (int j = 1; j <= N - i; j++) {
                if (array[j] == array[i + j] && dp[j + 1][i + j - 1]) {
                    dp[j][j + i] = true;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            sb.append((dp[S][E]) ? 1 : 0).append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}
