import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static final long[] dp = new long[31];

    private static void CatalanNumber() {
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= 30; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

//        DP Solution
//        long[][] dp = new long[31][31];
//
//        for (int w = 0; w < 31; w++) {
//            for (int h = 0; h < 31; h++) {
//                if (w >= h) {
//                    dp[w][h] = h == 0 ? 1 : dp[w - 1][h] + dp[w][h - 1];
//                }
//            }
//        }

        CatalanNumber();

        while (true) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) {
                break;
            }

            sb.append(dp[N]).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }
}
