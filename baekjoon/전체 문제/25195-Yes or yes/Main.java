import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static List<List<Integer>> tree;
    private static final Set<Integer> set = new HashSet<>();

    private static String dfs() {
        // [1] -> 1 == meet
        Stack<int[]> stack = new Stack<>();

        stack.push(new int[]{1, meet(1)});

        while (!stack.isEmpty()) {
            int[] currentNode = stack.pop();

            if (tree.get(currentNode[0]).isEmpty() && currentNode[1] == 0) {
                return "yes";
            }

            for (int nextNode : tree.get(currentNode[0])) {
                stack.push(new int[]{nextNode, currentNode[1] == 1 ? 1 : meet(nextNode)});
            }
        }

        return "Yes";
    }

    private static int meet(int node) {
        return set.contains(node) ? 1 : 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            tree.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }

        int S = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        bw.write(dfs());
        bw.flush();

        br.close();
        bw.close();
    }
}
