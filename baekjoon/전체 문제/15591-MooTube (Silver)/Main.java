import java.io.*;
import java.util.*;

public class Main {

    private static final Queue<Vertex> queue = new ArrayDeque<>();

    private static int N;

    private static List<List<Vertex>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken()); // USADO

            graph.get(vertex1).add(new Vertex(vertex2, weight));
            graph.get(vertex2).add(new Vertex(vertex1, weight));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            sb.append(bfs(v, k)).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static int bfs(int startVertex, int k) {
        int count = 0;

        boolean[] visited = new boolean[N + 1];
        visited[startVertex] = true;

        queue.offer(new Vertex(startVertex, 0));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            count++;

            for (Vertex nextVertex : graph.get(currentVertex.number)) {
                if (visited[nextVertex.number]) {
                    continue;
                }

                if (nextVertex.weight < k) {
                    continue;
                }

                visited[nextVertex.number] = true;

                queue.offer(nextVertex);
            }
        }

        // 자기 자신 제외
        return count - 1;
    }

    private static class Vertex {

        final int number;
        final int weight;

        Vertex(int number, int weight) {
            this.number = number;
            this.weight = weight;
        }
    }
}
