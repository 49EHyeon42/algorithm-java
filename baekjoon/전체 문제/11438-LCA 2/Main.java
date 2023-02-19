import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static final Map<Integer, Set<Integer>> tree = new HashMap<>();

    private static int maxLevel;

    private static int[][] parent;
    private static int[] level;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            tree.computeIfAbsent(node1, key -> new HashSet<>()).add(node2);
            tree.computeIfAbsent(node2, key -> new HashSet<>()).add(node1);
        }

        maxLevel = getMaxTreeLevel(N);

        int maxSize = getTreeSize(maxLevel);

        System.out.println("maxLevel = " + maxLevel);
        System.out.println("maxSize = " + maxSize);

        parent = new int[maxSize][18];
        level = new int[maxSize];

        setTree();

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            sb.append(lca(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())))
                    .append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void setTree() {
        Stack<int[]> stack = new Stack<>();

        // {parentNode, currentNode, currentLevel}
        stack.push(new int[]{0, 1, 1});

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int parentNode = current[0];
            int currentNode = current[1];
            int currentLevel = current[2];

            level[currentNode] = currentLevel;
            parent[currentNode][0] = parentNode;

            for (int i = 1; i <= maxLevel; i++) {
                parent[currentNode][i] = parent[parent[currentNode][i - 1]][i - 1];
            }

            for (int childNode : tree.get(currentNode)) {
                if (parentNode == childNode) {
                    continue;
                }

                stack.push(new int[]{currentNode, childNode, currentLevel + 1});
            }
        }
    }

    private static int lca(int node1, int node2) {
        if (node1 == 1 || node2 == 1) {
            return 1;
        }

        // node1이 더 깊다 가정
        if (level[node1] < level[node2]) {
            int swap = node1;
            node1 = node2;
            node2 = swap;
        }

        if (level[node1] != level[node2]) {
            for (int i = maxLevel; i >= 0; i--) {
                if (level[parent[node1][i]] >= level[node2]) {
                    node1 = parent[node1][i];
                }
            }
        }

        int lca = node1;

        if (node1 != node2) {
            for (int i = maxLevel; i >= 0; i--) {
                if (parent[node1][i] != parent[node2][i]) {
                    node1 = parent[node1][i];
                    node2 = parent[node2][i];
                }

                lca = parent[node1][i];
            }
        }

        return lca;
    }

    private static int getMaxTreeLevel(int size) {
        return (int) Math.ceil(Math.log10(size) / Math.log10(2));
    }

    private static int getTreeSize(int maxLevel) {
        return 1 << maxLevel;
    }
}
