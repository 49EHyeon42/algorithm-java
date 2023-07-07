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

        int T = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        Coin[] coins = new Coin[k + 1];

        int totalCount = 0;

        for (int i = 1; i <= k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            totalCount += count;

            coins[i] = new Coin(value, count);
        }

        // dp[i][j] = i 개의 동전 사용했을 때 j 값일 경우의 수
        int[][] dp = new int[totalCount + 1][T + 1];

        for (int i = 1; i <= k; i++) {
            Coin coin = coins[i];

            // i 개의 동전으로 0 값일 경우의 수, 항상 만들 수 있음
            dp[i - 1][0] = 1;

            for (int j = 1; j <= coin.count; j++) {
                for (int l = coin.value * j; l <= T; l++) {
                    // dp[i][l] = dp[i][l] + dp[i - 1][l - (coin.value * j)]
                    // coin.value * j(개수) = 동전으로 만들 수 있는 금액
                    dp[i][l] += dp[i - 1][l - (coin.value * j)];
                }
            }

            // i 개의 동전으로 j 값 총합
            for (int j = 1; j <= T; j++) {
                dp[i][j] += dp[i - 1][j];

                // DEBUG
                // if (dp[i][j] != 0) {
                //     System.out.println("동전 개수 = " + i + ", 값 = " + j + ", dp[i][j] = " + dp[i][j]);
                // }
            }
        }

        bw.write(Integer.toString(dp[k][T]));
        bw.flush();

        br.close();
        bw.close();
    }

    private final static class Coin {

        private final int value;
        private final int count;

        public Coin(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }
}
