import java.io.*;
import java.util.*;

public class Main {

    private static final Map<Integer, Set<Vertex>> graph = new HashMap<>();
    private static final PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.weight));

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            graph.put(i, new HashSet<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(vertex1).add(new Vertex(vertex2, weight));
            graph.get(vertex2).add(new Vertex(vertex1, weight));
        }

        st = new StringTokenizer(br.readLine());
        int middleVertex1 = Integer.parseInt(st.nextToken());
        int middleVertex2 = Integer.parseInt(st.nextToken());

        int tempMinWeight1 = getMinWeight(middleVertex1, middleVertex2);
        int tempMinWeight2 = getMinWeight(middleVertex2, middleVertex1);

        bw.write(Integer.toString(getResult(tempMinWeight1, tempMinWeight2)));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int getResult(int weight1, int weight2) {
        if (weight1 == -1 && weight2 == -1) {
            return -1;
        } else if (weight1 == -1) {
            return weight2;
        } else if (weight2 == -1) {
            return weight1;
        }

        return Math.min(weight1, weight2);
    }

    // 1 -> middle1 -> middle2 -> N
    // 2 -> middle2 -> middle1 -> N
    private static int getMinWeight(int middleVertex1, int middleVertex2) {
        int weight1 = dijkstra(1, middleVertex1);

        if (weight1 == -1) {
            return -1;
        }

        int weight2 = dijkstra(middleVertex1, middleVertex2);

        if (weight2 == -1) {
            return -1;
        }

        int weight3 = dijkstra(middleVertex2, N);

        if (weight3 == -1) {
            return -1;
        }

        return weight1 + weight2 + weight3;
    }

    private static int dijkstra(int startVertex, int endVertex) {
        int[] minWeights = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            minWeights[i] = Integer.MAX_VALUE;
        }

        minWeights[startVertex] = 0;
        pq.offer(new Vertex(startVertex, 0));

        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            if (currentVertex.weight > minWeights[currentVertex.number]) {
                continue;
            }

            for (Vertex nextVertex : graph.get(currentVertex.number)) {
                int nextWeight = currentVertex.weight + nextVertex.weight;

                if (nextWeight >= minWeights[nextVertex.number]) {
                    continue;
                }

                minWeights[nextVertex.number] = nextWeight;
                pq.offer(new Vertex(nextVertex.number, nextWeight));
            }
        }

        return minWeights[endVertex] == Integer.MAX_VALUE ? -1 : minWeights[endVertex];
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
