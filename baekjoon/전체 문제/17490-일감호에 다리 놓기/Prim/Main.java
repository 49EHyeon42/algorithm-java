import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        List<List<Vertex>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int weight = Integer.parseInt(st.nextToken());

            graph.get(0).add(new Vertex(i, weight));
            graph.get(i).add(new Vertex(0, weight));
        }

        boolean[] disconnectedVertex = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());

            if (vertex1 > vertex2) {
                int temp = vertex1;
                vertex1 = vertex2;
                vertex2 = temp;
            }

            if (vertex1 == 1 && vertex2 == N) {
                disconnectedVertex[N] = true;
            } else {
                disconnectedVertex[vertex1] = true;
            }
        }

        bw.write(M > 1 ? getResult(N, K, graph, disconnectedVertex) : "YES");

        bw.flush();
        bw.close();
    }

    private static String getResult(int N, long K, List<List<Vertex>> graph, boolean[] disconnectedVertex) {
        for (int vertex1 = 1; vertex1 <= N; vertex1++) {
            int vertex2 = vertex1 == N ? 1 : vertex1 + 1;

            if (disconnectedVertex[vertex1]) {
                continue;
            }

            graph.get(vertex1).add(new Vertex(vertex2, 0));
            graph.get(vertex2).add(new Vertex(vertex1, 0));
        }

        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.weight));
        pq.offer(new Vertex(1, 0));

        boolean[] visited = new boolean[N + 1];

        long minimumWeight = 0;

        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            if (visited[currentVertex.number]) {
                continue;
            }

            visited[currentVertex.number] = true;

            minimumWeight += currentVertex.weight;

            for (Vertex nextVertex : graph.get(currentVertex.number)) {
                if (visited[nextVertex.number]) {
                    continue;
                }

                pq.offer(nextVertex);
            }
        }

        return K - minimumWeight >= 0 ? "YES" : "NO";
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
