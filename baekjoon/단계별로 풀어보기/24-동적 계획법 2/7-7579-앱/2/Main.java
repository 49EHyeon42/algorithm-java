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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] bytes = new int[N + 1];
        int[] costs = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            bytes[i] = Integer.parseInt(st.nextToken());
        }

        int total = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
            total += costs[i];
        }

        // Knapsack
        int[] dp = new int[total + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = total; j >= costs[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - costs[i]] + bytes[i]);
            }
        }

        int minCost = 0;
        for (int i = 0; i <= total; i++) {
            if (dp[i] >= M) {
                minCost = i;
                break;
            }
        }

        bw.write(Integer.toString(minCost));
        bw.flush();
    }
}
