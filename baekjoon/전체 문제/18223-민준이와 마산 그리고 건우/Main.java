import java.io.*;
import java.util.*;

public class Main {

    private static int V;

    private static List<List<Vertex>> graph;

    private static final PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.weight));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(vertex1).add(new Vertex(vertex2, weight));
            graph.get(vertex2).add(new Vertex(vertex1, weight));
        }

        bw.write(dijkstra(1, V) == dijkstra(1, P) + dijkstra(P, V) ? "SAVE HIM" : "GOOD BYE");
        bw.flush();

        br.close();
        bw.close();
    }

    private static int dijkstra(int startVertex, int endVertex) {
        pq.clear();

        int[] minWeights = new int[V + 1];

        for (int i = 0; i <= V; i++) {
            minWeights[i] = Integer.MAX_VALUE;
        }

        minWeights[startVertex] = 0;

        pq.offer(new Vertex(startVertex, 0));

        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            if (minWeights[currentVertex.number] < currentVertex.weight) {
                continue;
            }

            if (currentVertex.number == endVertex) {
                return minWeights[endVertex];
            }

            for (Vertex nextVertex : graph.get(currentVertex.number)) {
                int nextWeight = minWeights[currentVertex.number] + nextVertex.weight;

                if (minWeights[nextVertex.number] <= nextWeight) {
                    continue;
                }

                minWeights[nextVertex.number] = nextWeight;

                pq.offer(new Vertex(nextVertex.number, nextWeight));
            }
        }

        return minWeights[endVertex];
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
