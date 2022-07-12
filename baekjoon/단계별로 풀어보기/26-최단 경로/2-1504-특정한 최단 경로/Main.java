import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// two-way : sequential search, priority queue
public class Main {

    private static final int INF = Integer.MAX_VALUE;

    private static final ArrayList<ArrayList<Vertex>> graph = new ArrayList<>();
    private static int[] weights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertexNumber = Integer.parseInt(st.nextToken());
        int edgeNumber = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= vertexNumber; i++) {
            graph.add(new ArrayList<>());
        }

        weights = new int[vertexNumber + 1];
        initWeights();

        for (int i = 0; i < edgeNumber; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Vertex(v, w));
            graph.get(v).add(new Vertex(u, w));
        }

        st = new StringTokenizer(br.readLine());
        int requiredVertex1 = Integer.parseInt(st.nextToken());
        int requiredVertex2 = Integer.parseInt(st.nextToken());

        dijkstra(1);
        int weightOfStartTo1 = weights[requiredVertex1];
        int weightOfStartTo2 = weights[requiredVertex2];
        initWeights();

        dijkstra(requiredVertex1);
        int weightOf1To2 = weights[requiredVertex2];
        int weightOf1ToEnd = weights[vertexNumber];
        initWeights();

        dijkstra(requiredVertex2);
        int weightOf2ToEnd = weights[vertexNumber];

        boolean flag = true;
        int minWeight = INF;
        if (weightOfStartTo1 == INF || weightOf1To2 == INF || weightOf2ToEnd == INF) {
            flag = false;
        } else {
            minWeight = Math.min(minWeight,
                weightOfStartTo1 + weightOf1To2 + weightOf2ToEnd);
        }

        if (weightOfStartTo2 == INF || weightOf1To2 == INF || weightOf1ToEnd == INF) {
            flag = false;
        } else {
            minWeight = Math.min(minWeight,
                weightOfStartTo2 + weightOf1To2 + weightOf1ToEnd);
        }

        bw.write(Long.toString((flag && minWeight != INF) ? minWeight : -1));

        bw.flush();
        bw.close();
    }

    private static void dijkstra(int startVertex) {
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();

        weights[startVertex] = 0;
        priorityQueue.offer(new Vertex(startVertex, 0));

        while (!priorityQueue.isEmpty()) {
            int currentVertexValue = priorityQueue.peek().getValue();
            int currentVertexWeight = priorityQueue.peek().getWeight();
            priorityQueue.poll();

            for (Vertex nextVertex : graph.get(currentVertexValue)) {
                int nextVertexValue = nextVertex.getValue();
                int nextVertexWeight = nextVertex.getWeight() + currentVertexWeight;

                if (nextVertexWeight < weights[nextVertexValue]) {
                    weights[nextVertexValue] = nextVertexWeight;
                    priorityQueue.offer(new Vertex(nextVertexValue, nextVertexWeight));
                }
            }
        }
    }

    private static void initWeights() {
        Arrays.fill(weights, INF);
    }

    private static class Vertex implements Comparable<Vertex> {

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

        @Override
        public int compareTo(Vertex o) {
            return this.weight - o.weight;
        }
    }
}
