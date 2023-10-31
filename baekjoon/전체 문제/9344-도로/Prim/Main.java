import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        List<List<Vertex>> graph = new ArrayList<>();

        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.weight));

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            graph.clear();

            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            boolean[] visited = new boolean[N + 1];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int vertex1 = Integer.parseInt(st.nextToken());
                int vertex2 = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                graph.get(vertex1).add(new Vertex(vertex1, vertex2, weight));
                graph.get(vertex2).add(new Vertex(vertex2, vertex1, weight));
            }

            pq.offer(new Vertex(-1, 1, 0));

            sb.append(getResult(graph, pq, visited, p, q)).append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    private static String getResult(List<List<Vertex>> graph, PriorityQueue<Vertex> pq, boolean[] visited, int p, int q) {
        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            if (visited[currentVertex.to]) {
                continue;
            }

            visited[currentVertex.to] = true;

            if ((currentVertex.from == p && currentVertex.to == q) || (currentVertex.from == q && currentVertex.to == p)) {
                return "YES";
            }

            for (Vertex nextVertex : graph.get(currentVertex.to)) {
                if (visited[nextVertex.to]) {
                    continue;
                }

                pq.offer(nextVertex);
            }
        }

        return "NO";
    }

    private static class Vertex {

        final int from;
        final int to;
        final int weight;

        Vertex(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
