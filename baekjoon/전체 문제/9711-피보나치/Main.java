import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static long[] dp = new long[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());

            sb.append("Case #").append(i).append(": ").append(fibonacci(P, Q)).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static long fibonacci(int P, int Q) {
        if (Q == 1) {
            return 0;
        }

        dp[1] = 1;

        for (int i = 2; i <= P; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % Q;
        }

        return dp[P];
    }
}
