import java.io.*;
import java.util.*;

public class Main {

    private static final Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Set<Integer>> reverseGraph = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            graph.put(i, new HashSet<>());
            reverseGraph.put(i, new HashSet<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());

            graph.get(vertex1).add(vertex2);
            reverseGraph.get(vertex2).add(vertex1);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N + 1];

            dfs(graph, visited, i);
            dfs(reverseGraph, visited, i);

            int count = 0;

            for (int j = 1; j <= N; j++) {
                if (!visited[j]) {
                    count++;
                }
            }

            sb.append(count).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void dfs(Map<Integer, Set<Integer>> graph, boolean[] visited, int startVertex) {
        visited[startVertex] = true;

        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();

            for (int nextVertex : graph.get(currentVertex)) {
                if (visited[nextVertex]) {
                    continue;
                }

                visited[nextVertex] = true;

                stack.push(nextVertex);
            }
        }
    }
}
