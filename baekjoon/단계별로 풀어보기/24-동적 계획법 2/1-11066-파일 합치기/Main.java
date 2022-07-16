import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCaseNumber = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCaseNumber; i++) {
            int chapterNumber = Integer.parseInt(br.readLine());

            int[][] dp = new int[chapterNumber + 1][chapterNumber + 1]; // N~M 파일의 최소
            int[] sum = new int[chapterNumber + 1]; // 1~N 파일의 합
            int[] chapters = new int[chapterNumber + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= chapterNumber; j++) {
                chapters[j] = Integer.parseInt(st.nextToken());
                sum[j] = sum[j - 1] + chapters[j];
            }

            // O(N^3), 다른 방법 있음
            for (int j = 1; j <= chapterNumber; j++) {
                for (int k = 1; k <= chapterNumber - j; k++) {
                    dp[k][j + k] = INF;
                    for (int l = k; l < j + k; l++) {
                        dp[k][j + k] = Math.min(dp[k][j + k],
                            dp[k][l] + dp[l + 1][j + k] + sum[j + k] - sum[k - 1]);
                    }
                }
            }

            sb.append(dp[1][chapterNumber]).append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}
