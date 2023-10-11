import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertexNumber = Integer.parseInt(st.nextToken());
        int edgeNumber = Integer.parseInt(st.nextToken());

        List<List<Vertex>> graph = new ArrayList<>();

        for (int i = 0; i <= vertexNumber; i++) {
            graph.add(new ArrayList<>());
        }

        boolean[] visited = new boolean[vertexNumber + 1];

        long totalWeight = 0;

        for (int i = 0; i < edgeNumber; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            totalWeight += weight;

            graph.get(vertex1).add(new Vertex(vertex2, weight));
            graph.get(vertex2).add(new Vertex(vertex1, weight));
        }

        long minimumWeight = 0;

        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.weight));

        pq.offer(new Vertex(1, 0));

        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            if (visited[currentVertex.number]) {
                continue;
            }

            visited[currentVertex.number] = true;

            minimumWeight += currentVertex.weight;

            for (Vertex nextVertex : graph.get(currentVertex.number)) {
                if (visited[nextVertex.number]) {
                    continue;
                }

                pq.offer(nextVertex);
            }
        }

        boolean visitedAll = true;

        for (int i = 1; i <= vertexNumber; i++) {
            if (!visited[i]) {
                visitedAll = false;
                break;
            }
        }

        bw.write(Long.toString(visitedAll ? totalWeight - minimumWeight : -1));

        bw.flush();
        bw.close();
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
