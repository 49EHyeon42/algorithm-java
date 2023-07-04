import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static List<List<Integer>> tree;
    private static boolean[] visited;
    private static int[] dp;

    private static void dfs(int rootNode) {
        Stack<Integer> stack = new Stack<>();

        stack.push(rootNode);
        visited[rootNode] = true;

        while (!stack.isEmpty()) {
            int currentNode = stack.pop();

            for (int nextNode : tree.get(currentNode)) {
                if (visited[nextNode]) {
                    continue;
                }

                stack.push(nextNode);
                visited[nextNode] = true;

                dp[nextNode] += dp[currentNode];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        visited = new boolean[n + 1];
        dp = new int[n + 1];

        int rootNode = -1;

        st = new StringTokenizer(br.readLine());
        for (int childNode = 1; childNode <= n; childNode++) {
            int parentNode = Integer.parseInt(st.nextToken());

            if (parentNode == -1) {
                rootNode = childNode;
                continue;
            }

            tree.get(childNode).add(parentNode);
            tree.get(parentNode).add(childNode);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            dp[Integer.parseInt(st.nextToken())] += Integer.parseInt(st.nextToken());
        }

        dfs(rootNode);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(dp[i]).append(' ');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }
}
