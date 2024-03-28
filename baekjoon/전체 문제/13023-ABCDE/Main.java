import java.io.*;
import java.util.*;

public class Main {

    private static Map<Integer, Set<Integer>> graph;
    private static boolean[] visited;

    private static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }

        visited = new boolean[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i < n; i++) {
            if (flag) {
                break;
            }

            backtracking(1, i);
        }

        bw.write(flag ? '1' : '0');
        bw.flush();

        br.close();
        bw.close();
    }

    private static void backtracking(int count, int vertex) {
        if (count == 5) {
            flag = true;

            return;
        }

        visited[vertex] = true;

        for (int nextVertex : graph.get(vertex)) {
            if (flag) {
                return;
            }

            if (visited[nextVertex]) {
                continue;
            }

            backtracking(count + 1, nextVertex);
        }

        visited[vertex] = false;
    }
}
