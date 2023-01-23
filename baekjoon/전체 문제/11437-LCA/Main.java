import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static final Map<Integer, Set<Integer>> tree = new HashMap<>();
    private static int[] parent;
    private static int[] level;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // init tree
        for (int i = 0; i <= N; i++) {
            tree.put(i, new HashSet<>());
        }

        // add edge
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            tree.get(node1).add(node2);
            tree.get(node2).add(node1);
        }

        // init parent, level
        parent = new int[N + 1];

        level = new int[N + 1];

        // get parent, level
        dfs(1, 1);

        int M = Integer.parseInt(br.readLine());

        // get result from LCA
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            sb.append(lca(node1, node2)).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void dfs(int parentNode, int currentNode) {
        parent[currentNode] = parentNode;
        level[currentNode] = level[parentNode] + 1;

        for (int childNode : tree.get(currentNode)) {
            if (parentNode != childNode) {
                dfs(currentNode, childNode);
            }
        }
    }

    private static int lca(int node1, int node2) {
        // node1 이 더 깊다고 가정
        if (level[node1] < level[node2]) {
            int temp = node1;
            node1 = node2;
            node2 = temp;
        }

        // node1 과 node2 의 레벨 맞추기
        while (level[node1] != level[node2]) {
            node1 = parent[node1];
        }

        // 최소 공통 조상 찾기
        while (node1 != node2) {
            node1 = parent[node1];
            node2 = parent[node2];
        }

        return node1;
    }
}
