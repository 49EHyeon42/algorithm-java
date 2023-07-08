import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final List<List<Integer>> tree = new ArrayList<>();
    private static long[] dp;

    private static long dfs(int node) {
        if (!tree.get(node).isEmpty()) {
            for (int childNode : tree.get(node)) {
                dp[node] = Math.max(dp[node], dp[node] + dfs(childNode));
            }
        }

        return dp[node];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tree.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }

        dp = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(Long.toString(dfs(0)));
        bw.flush();

        br.close();
        bw.close();
    }
}
