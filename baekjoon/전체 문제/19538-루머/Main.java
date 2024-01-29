import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int i = 0; i < N; i++) {
            graph.put(i, new HashSet<>());
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            while (true) {
                int vertex = Integer.parseInt(st.nextToken());

                if (vertex == 0) {
                    break;
                }

                graph.get(i).add(vertex - 1);
            }
        }

        int M = Integer.parseInt(br.readLine());

        int[] startVertices = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            startVertices[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        int[] visited = bfs(N, startVertices, graph);

        // array to string
        StringBuilder sb = new StringBuilder();
        for (int i : visited) {
            sb.append(i).append(' ');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static int[] bfs(int N, int[] startVertices, Map<Integer, Set<Integer>> graph) {
        int[] visited = new int[N];
        Arrays.fill(visited, -1);

        int[] near = new int[N];

        Queue<Integer> queue = new ArrayDeque<>();

        for (int startVertex : startVertices) {
            visited[startVertex] = 0;

            queue.offer(startVertex);
        }

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            for (int nextVertex : graph.get(currentVertex)) {
                near[nextVertex]++;

                if (visited[nextVertex] != -1) {
                    continue;
                }

                if (near[nextVertex] < (graph.get(nextVertex).size() + 1) / 2) {
                    continue;
                }

                queue.offer(nextVertex);

                visited[nextVertex] = visited[currentVertex] + 1;
            }
        }

        return visited;
    }
}
