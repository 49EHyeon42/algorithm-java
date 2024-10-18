import java.io.*;
import java.util.*;

public class Main {

    private static final Map<Integer, Set<Vertex>> graph = new HashMap<>();
    private static final PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.weight));

    private static int[] minWeights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        minWeights = new int[V + 1];

        int startVertex = Integer.parseInt(br.readLine());

        for (int i = 1; i <= V; i++) {
            graph.put(i, new HashSet<>());

            minWeights[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(vertex1).add(new Vertex(vertex2, weight));
            graph.get(vertex1).add(new Vertex(vertex1, weight));
        }

        dijkstra(startVertex);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= V; i++) {
            sb.append(minWeights[i] == Integer.MAX_VALUE ? "INF" : minWeights[i]).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void dijkstra(int startVertex) {
        pq.offer(new Vertex(startVertex, 0));
        minWeights[startVertex] = 0;

        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            if (minWeights[currentVertex.number] < currentVertex.weight) {
                continue;
            }

            for (Vertex nextVertex : graph.get(currentVertex.number)) {
                int nextWeight = currentVertex.weight + nextVertex.weight;

                if (minWeights[nextVertex.number] <= nextWeight) {
                    continue;
                }

                pq.offer(new Vertex(nextVertex.number, nextWeight));
                minWeights[nextVertex.number] = nextWeight;
            }
        }
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
