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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] array = new int[n][m];
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            String string = br.readLine();

            for (int j = 0; j < m; j++) {
                array[i][j] = string.charAt(j) - '0';
            }
        }

        int maxLength = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            dp[i][0] = array[i][0];

            maxLength = Math.max(maxLength, dp[i][0]);
        }

        for (int i = 0; i < m; i++) {
            dp[0][i] = array[0][i];

            maxLength = Math.max(maxLength, dp[0][i]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (array[i][j] == 1 &&
                        !(dp[i - 1][j - 1] == 0 || dp[i - 1][j] == 0 || dp[i][j - 1] == 0)) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1],
                            Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;

                    maxLength = Math.max(maxLength, dp[i][j]);
                } else {
                    dp[i][j] = array[i][j];
                }
            }
        }

        bw.write(Integer.toString(maxLength * maxLength));
        bw.flush();

        br.close();
        bw.close();
    }
}
