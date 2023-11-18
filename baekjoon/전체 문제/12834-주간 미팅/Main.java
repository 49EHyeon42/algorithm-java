import java.io.*;
import java.util.*;

public class Main {

    private static int V;

    private static int[] kistAndCrFood;

    private static List<List<Vertex>> graph;

    private static final PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.weight));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // [0] = KIST, [1] = CRFood
        kistAndCrFood = new int[2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2; i++) {
            kistAndCrFood[i] = Integer.parseInt(st.nextToken());
        }

        int[] homes = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            homes[i] = Integer.parseInt(st.nextToken());
        }

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

        int sum = 0;

        for (int startVertex : homes) {
            sum += dijkstra(startVertex);
        }

        bw.write(Integer.toString(sum));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int dijkstra(int startVertex) {
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

            for (Vertex nextVertex : graph.get(currentVertex.number)) {
                int nextWeight = minWeights[currentVertex.number] + nextVertex.weight;

                if (minWeights[nextVertex.number] <= nextWeight) {
                    continue;
                }

                minWeights[nextVertex.number] = nextWeight;

                pq.offer(new Vertex(nextVertex.number, nextWeight));
            }
        }

        int result = 0;

        for (int index : kistAndCrFood) {
            result += minWeights[index] == Integer.MAX_VALUE ? -1 : minWeights[index];
        }

        return result;
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
