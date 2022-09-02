import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static final ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static final ArrayList<ArrayList<Integer>> reverseGraph = new ArrayList<>();

    private static boolean[] isVisited;

    private static final Stack<Integer> stack = new Stack<>();

    private static final ArrayList<ArrayList<Integer>> scc = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); // V = vertex count
        int E = Integer.parseInt(st.nextToken()); // E = edge count

        // init
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }
        isVisited = new boolean[V + 1];

        // add graph edge
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            reverseGraph.get(B).add(A);
        }

        // sort graph
        for (int i = 1; i <= V; i++) {
            graph.get(i).sort(Comparator.reverseOrder());
            reverseGraph.get(i).sort(Comparator.reverseOrder());
        }

        // dfs
        for (int i = 1; i <= V; i++) {
            if (!isVisited[i]) {
                dfs(i);
            }
        }

        // init isVisited
        Arrays.fill(isVisited, false);

        // reverse dfs
        int id = 0;

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();

            if (!isVisited[currentVertex]) {
                scc.add(new ArrayList<>());

                reverseDfs(currentVertex, id++);
            }
        }

        // output
        for (ArrayList<Integer> arrayList : scc) {
            arrayList.sort(Comparator.comparingInt(Integer::intValue));
        }
        scc.sort(Comparator.comparingInt(o -> o.get(0)));

        StringBuilder sb = new StringBuilder();

        sb.append(id).append('\n');

        for (ArrayList<Integer> arrayList : scc) {
            for (Integer integer : arrayList) {
                sb.append(integer).append(' ');
            }
            sb.append(-1).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();
    }

    private static void dfs(int startVertex) {
        isVisited[startVertex] = true;

        for (int nextVertex : graph.get(startVertex)) {
            if (!isVisited[nextVertex]) {
                dfs(nextVertex);
            }
        }

        stack.push(startVertex);
    }

    private static void reverseDfs(int startVertex, int id) {
        isVisited[startVertex] = true;

        scc.get(id).add(startVertex);

        for (int nextVertex : reverseGraph.get(startVertex)) {
            if (!isVisited[nextVertex]) {
                reverseDfs(nextVertex, id);
            }
        }
    }
}
