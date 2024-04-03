import java.io.*;
import java.util.*;

public class Main {

    private static final Stack<Integer> stack = new Stack<>();

    private static Map<Integer, Set<Integer>> graph;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new HashMap<>();

        visited = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            graph.put(i, new HashSet<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= N; i++) {
            dfs(i);
        }

        int count = 0;

        for (int i = 1; i <= N; i++) {
            boolean flag = true;

            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    continue;
                }

                if (!(visited[i][j] || visited[j][i])) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                count++;
            }
        }

        bw.write(Integer.toString(count));
        bw.flush();

        br.close();
        bw.close();
    }

    private static void dfs(int startVertex) {
        visited[startVertex][startVertex] = true;

        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();

            for (int nextVertex : graph.get(currentVertex)) {
                if (visited[startVertex][nextVertex]) {
                    continue;
                }

                visited[startVertex][nextVertex] = true;

                stack.push(nextVertex);
            }
        }
    }
}
