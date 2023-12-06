import java.io.*;
import java.util.*;

public class Main {

    private static final PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.weight));

    private static int vertexNumber;
    private static List<List<Vertex>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        vertexNumber = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= vertexNumber; i++) {
            graph.add(new ArrayList<>());
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());

            if (vertex1 == -1 && vertex2 == -1) {
                break;
            }

            graph.get(vertex1).add(new Vertex(vertex2, 1));
            graph.get(vertex2).add(new Vertex(vertex1, 1));
        }

        int[] maxs = new int[vertexNumber + 1];

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= vertexNumber; i++) {
            maxs[i] = dijkstra(i);

            if (min > maxs[i]) {
                min = maxs[i];
            }
        }

        int count = 0;

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < maxs.length; i++) {
            if (min == maxs[i]) {
                count++;
                list.add(i);
            }
        }

        sb.append(min).append(' ').append(count).append('\n');

        for (int i : list) {
            sb.append(i).append(' ');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static int dijkstra(int startVertex) {
        int[] minWeights = new int[vertexNumber + 1];
        Arrays.fill(minWeights, Integer.MAX_VALUE);
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

        int max = 0;

        for (int i = 1; i < minWeights.length; i++) {
            if (max < minWeights[i]) {
                max = minWeights[i];
            }
        }

        return max;
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
