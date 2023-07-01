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

    private static int lengthOfTrunk = 0;

    private static final Stack<int[]> stack = new Stack<>();
    private static boolean[] visited;

    // get length of trunk, giga node
    private static int dfs1(List<List<int[]>> tree, int rootNode) {
        stack.push(new int[]{rootNode, 0});
        visited[rootNode] = true;

        int gigaNode = -1;

        while (!stack.isEmpty()) {
            int[] currentNode = stack.pop();

            gigaNode = currentNode[0];

            if (tree.get(currentNode[0]).size() > 2) {
                continue;
            }

            for (int[] nextNode : tree.get(currentNode[0])) {
                if (!visited[nextNode[0]]) {
                    lengthOfTrunk += nextNode[1];

                    stack.push(nextNode);
                    visited[nextNode[0]] = true;
                }
            }
        }

        // return giga node
        return gigaNode;
    }

    // get max length of branch
    private static int dfs2(List<List<int[]>> tree, int gigaNode) {
        int maxLengthOfBranch = 0;

        stack.push(new int[]{gigaNode, 0});
        visited[gigaNode] = true;

        while (!stack.isEmpty()) {
            int[] currentNode = stack.pop();

            for (int[] nextNode : tree.get(currentNode[0])) {
                if (!visited[nextNode[0]]) {
                    int lengthOfBranch = currentNode[1] + nextNode[1];

                    maxLengthOfBranch = Math.max(maxLengthOfBranch, lengthOfBranch);

                    stack.push(new int[]{nextNode[0], lengthOfBranch});
                    visited[nextNode[0]] = true;
                }
            }
        }

        return maxLengthOfBranch;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        List<List<int[]>> tree = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        visited = new boolean[N + 1];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            tree.get(a).add(new int[]{b, d});
            tree.get(b).add(new int[]{a, d});
        }

        // if tree.get(R).size() == 2 -> length of trunk = 0
        int gigaNode = tree.get(R).size() == 2 ? R : dfs1(tree, R);

        int maxLengthOfBranch = dfs2(tree, gigaNode);

        bw.write(lengthOfTrunk + " " + maxLengthOfBranch);
        bw.flush();

        br.close();
        bw.close();
    }
}
