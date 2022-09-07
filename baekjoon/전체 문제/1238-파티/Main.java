import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX_WEIGHT = Integer.MAX_VALUE;

    private static int N;
    private static int X;

    private static final ArrayList<ArrayList<Vertex>> graph = new ArrayList<>();
    private static final ArrayList<ArrayList<Vertex>> reverseGraph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int fromVertex = Integer.parseInt(st.nextToken());
            int toVertex = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(fromVertex).add(new Vertex(toVertex, weight));
            reverseGraph.get(toVertex).add(new Vertex(fromVertex, weight));
        }

        for (int i = 0; i <= N; i++) {
            graph.get(i).sort(Comparator.comparingInt(Vertex::getWeight));
            reverseGraph.get(i).sort(Comparator.comparingInt(Vertex::getWeight));
        }

        int[] minWeights = dijkstra(graph);
        int[] reverseMinWeights = dijkstra(reverseGraph);

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, minWeights[i] + reverseMinWeights[i]);
        }

        bw.write(Integer.toString(answer));
        bw.flush();
    }

    private static int[] dijkstra(ArrayList<ArrayList<Vertex>> graph) {
        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(Vertex::getWeight));
        int[] minWeights = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            minWeights[i] = MAX_WEIGHT;
        }

        pq.offer(new Vertex(X, 0));
        minWeights[X] = 0;

        while (!pq.isEmpty()) {
            int currentVertexValue = pq.peek().getValue();
            int currentVertexWeight = pq.peek().getWeight();

            pq.poll();

            for (Vertex nextVertex : graph.get(currentVertexValue)) {
                int nextVertexValue = nextVertex.getValue();
                int nextVertexWeight = nextVertex.getWeight() + currentVertexWeight;

                if (minWeights[nextVertexValue] > nextVertexWeight) {
                    pq.offer(new Vertex(nextVertexValue, nextVertexWeight));
                    minWeights[nextVertexValue] = nextVertexWeight;
                }
            }
        }

        return minWeights;
    }

    private static class Vertex {

        private final int value;
        private final int weight;

        public Vertex(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }

        public int getValue() {
            return value;
        }

        public int getWeight() {
            return weight;
        }
    }
}
