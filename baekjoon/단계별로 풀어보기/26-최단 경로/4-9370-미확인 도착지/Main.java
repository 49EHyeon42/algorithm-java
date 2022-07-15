import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Dijkstra's algorithm,
// 후보 중 g와 h를 지나는 최단 경로 정점들 모두 찾기
public class Main {

    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int vertexNumber = Integer.parseInt(st.nextToken());
            int edgeNumber = Integer.parseInt(st.nextToken());
            int candidateNumber = Integer.parseInt(st.nextToken());

            int[] distanceS = new int[vertexNumber + 1];
            int[] distanceG = new int[vertexNumber + 1];
            int[] distanceH = new int[vertexNumber + 1];
            for (int j = 1; j <= vertexNumber; j++) {
                distanceS[j] = distanceH[j] = distanceG[j] = INF;
            }

            ArrayList<ArrayList<Vertex>> graph = new ArrayList<>();
            for (int j = 0; j <= vertexNumber; j++) {
                graph.add(new ArrayList<>());
            }

            int[] candidates = new int[candidateNumber];

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            for (int j = 0; j < edgeNumber; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                graph.get(a).add(new Vertex(b, d));
                graph.get(b).add(new Vertex(a, d));
            }

            for (int j = 0; j < candidateNumber; j++) {
                candidates[j] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(candidates);

            dijkstra(graph, s, distanceS);
            dijkstra(graph, g, distanceG);
            dijkstra(graph, h, distanceH);

            for (int j = 0; j < candidateNumber; j++) {
                if (distanceS[candidates[j]]
                    == distanceS[g] + distanceG[h] + distanceH[candidates[j]]
                    || distanceS[candidates[j]] ==
                    distanceS[h] + distanceH[g] + distanceG[candidates[j]]) {
                    sb.append(candidates[j]).append(' ');
                }
            }
            sb.append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    private static void dijkstra(ArrayList<ArrayList<Vertex>> graph,
        int startVertex, int[] distance) {
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();

        distance[startVertex] = 0;
        priorityQueue.offer(new Vertex(startVertex, 0));

        while (!priorityQueue.isEmpty()) {
            int currentVertexValue = priorityQueue.peek().getValue();
            int currentVertexWeight = priorityQueue.peek().getWeight();
            priorityQueue.poll();

            for (Vertex nextVertex : graph.get(currentVertexValue)) {
                int nextVertexValue = nextVertex.getValue();
                int nextVertexWeight = nextVertex.getWeight() + currentVertexWeight;

                if (nextVertexWeight < distance[nextVertexValue]) {
                    distance[nextVertexValue] = nextVertexWeight;
                    priorityQueue.offer(new Vertex(nextVertexValue, nextVertexWeight));
                }
            }
        }
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
