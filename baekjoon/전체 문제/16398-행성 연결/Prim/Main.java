import java.io.*;
import java.util.*;

public class Main {

    private static List<List<Vertex>> graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int vertexNumber = Integer.parseInt(br.readLine());

        // init
        graph = new ArrayList<>();
        visited = new boolean[vertexNumber];

        // 양방향 그래프
        for (int i = 0; i < vertexNumber; i++) {
            graph.add(new ArrayList<>());

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < vertexNumber; j++) {
                if (i == j) {
                    st.nextToken();
                    continue;
                }

                graph.get(i).add(new Vertex(j, Integer.parseInt(st.nextToken())));
            }
        }

        bw.write(Long.toString(prim()));

        bw.flush();
        bw.close();
    }

    private static long prim() {
        long totalWeight = 0;

        // pq = priorityQueue
        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.weight));

        // start vertex = 0
        pq.offer(new Vertex(0, 0));

        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            if (visited[currentVertex.number]) {
                continue;
            }

            totalWeight += currentVertex.weight;

            visited[currentVertex.number] = true;

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
