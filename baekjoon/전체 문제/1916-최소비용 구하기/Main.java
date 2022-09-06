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

    private static final ArrayList<ArrayList<Vertex>> graph = new ArrayList<>();
    private static int[] minWeights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // N = vertex count
        int M = Integer.parseInt(br.readLine()); // M = edge count

        // init
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        minWeights = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            minWeights[i] = MAX_WEIGHT;
        }

        // add edge
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int fromVertex = Integer.parseInt(st.nextToken());
            int toVertex = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(fromVertex).add(new Vertex(toVertex, weight));
        }

        // 시간 초과 방지
        for (ArrayList<Vertex> list : graph) {
            list.sort(Comparator.comparingInt(Vertex::getWeight));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startVertex = Integer.parseInt(st.nextToken());
        int endVertex = Integer.parseInt(st.nextToken());

        dijkstra(startVertex);

        bw.write(Integer.toString(minWeights[endVertex]));
        bw.flush();
    }

    private static void dijkstra(int startVertex) {
        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(Vertex::getWeight));

        pq.offer(new Vertex(startVertex, 0));
        minWeights[startVertex] = 0;

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
