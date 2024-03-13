import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static final PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.weight));

    private static int n;
    private static int[][] graph;
    private static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                graph[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[vertex1][vertex2] = weight;
            graph[vertex2][vertex1] = weight;
        }

        result = new int[n + 1][n + 1];

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            dijkstra(i);

            for (int j = 1; j <= n; j++) {
                sb.append(i == j ? "-" : result[i][j]).append(' ');
            }

            sb.append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void dijkstra(int startVertex) {
        int[] visited = new int[n + 1];

        Arrays.fill(visited, Integer.MAX_VALUE);

        visited[startVertex] = 0;

        pq.offer(new Vertex(startVertex, 0));

        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            if (visited[currentVertex.number] < currentVertex.weight) {
                continue;
            }

            for (int nextVertexNumber = 1; nextVertexNumber <= n; nextVertexNumber++) {
                if (graph[currentVertex.number][nextVertexNumber] == Integer.MAX_VALUE) {
                    continue;
                }

                int nextWeight = currentVertex.weight + graph[currentVertex.number][nextVertexNumber];

                if (visited[nextVertexNumber] <= nextWeight) {
                    continue;
                }

                visited[nextVertexNumber] = nextWeight;

                pq.offer(new Vertex(nextVertexNumber, nextWeight));

                result[startVertex][nextVertexNumber] = currentVertex.number == startVertex ? nextVertexNumber : result[startVertex][currentVertex.number];
            }
        }
    }

    private static class Vertex {

        int number;
        int weight;

        Vertex(int number, int weight) {
            this.number = number;
            this.weight = weight;
        }
    }
}
