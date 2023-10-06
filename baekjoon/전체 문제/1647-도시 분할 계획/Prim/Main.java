import java.io.*;
import java.util.*;

public class Main {

    private static List<List<Vertex>> graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertexNumber = Integer.parseInt(st.nextToken());
        int edgeNumber = Integer.parseInt(st.nextToken());

        // init
        graph = new ArrayList<>();

        for (int i = 0; i <= vertexNumber; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new boolean[vertexNumber + 1];

        for (int i = 0; i < edgeNumber; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(vertex1).add(new Vertex(vertex2, weight));
            graph.get(vertex2).add(new Vertex(vertex1, weight));
        }

        bw.write(Integer.toString(prim()));

        bw.flush();
        bw.close();
    }

    private static int prim() {
        int maximumWeight = 0;
        int totalWeight = 0;

        // pq = priorityQueue
        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.weight));

        // start vertex = 1
        pq.offer(new Vertex(1, 0));

        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            if (visited[currentVertex.number]) {
                continue;
            }

            maximumWeight = Integer.max(maximumWeight, currentVertex.weight);
            totalWeight += currentVertex.weight;

            visited[currentVertex.number] = true;

            for (Vertex nextVertex : graph.get(currentVertex.number)) {
                if (visited[nextVertex.number]) {
                    continue;
                }

                pq.offer(nextVertex);
            }
        }

        return totalWeight - maximumWeight;
    }

    private static class Vertex {

        private final int number;
        private final int weight;

        Vertex(int number, int weight) {
            this.number = number;
            this.weight = weight;
        }
    }
}
