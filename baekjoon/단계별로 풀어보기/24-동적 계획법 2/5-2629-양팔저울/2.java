import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// reference : https://kangwlgns.tistory.com/5
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int weightNumber = Integer.parseInt(br.readLine());

        boolean[][] dp = new boolean[weightNumber + 1][40001];
        dp[0][0] = true;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= weightNumber; i++) {
            dp[i][0] = true;

            int weight = Integer.parseInt(st.nextToken());
            for (int j = 0; j <= 40000; j++) {
                dp[i][j] = dp[i - 1][j] || dp[i - 1][Math.abs(j - weight)];
                if (j + weight <= 40000) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j + weight];
                }
            }
        }

        int beadNumber = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < beadNumber; i++) {
            int beadWeight = Integer.parseInt(st.nextToken());

            if (dp[weightNumber][beadWeight]) {
                sb.append("Y ");
            } else {
                sb.append("N ");
            }
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}
