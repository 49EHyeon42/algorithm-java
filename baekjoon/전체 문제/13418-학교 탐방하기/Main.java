import java.io.*;
import java.util.*;

public class Main {

    private static final List<List<Vertex>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertexNumber = Integer.parseInt(st.nextToken());
        int edgeNumber = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= vertexNumber; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i <= edgeNumber; i++) { // 0-1 포함
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            int status = Integer.parseInt(st.nextToken());

            graph.get(vertex1).add(new Vertex(vertex2, status));
            graph.get(vertex2).add(new Vertex(vertex1, status));
        }

        long worstWeight = prim(new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.weight)), new boolean[vertexNumber + 1]);
        long bestWeight = prim(new PriorityQueue<>((vertex1, vertex2) -> vertex2.weight - vertex1.weight), new boolean[vertexNumber + 1]);

        bw.write(Long.toString(worstWeight * worstWeight - bestWeight * bestWeight));

        bw.flush();
        bw.close();
    }

    private static long prim(PriorityQueue<Vertex> pq, boolean[] visited) {
        long totalWeight = 0;

        // start 0
        pq.offer(new Vertex(0, 1));

        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            if (visited[currentVertex.number]) {
                continue;
            }

            visited[currentVertex.number] = true;

            if (currentVertex.weight == 0) {
                totalWeight++;
            }

            for (Vertex nextVertex : graph.get(currentVertex.number)) {
                if (visited[nextVertex.number]) {
                    continue;
                }

                pq.offer(nextVertex);
            }
        }

        return totalWeight;
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
