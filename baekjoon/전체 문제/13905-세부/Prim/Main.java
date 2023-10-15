import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX_WEIGHT = 10000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertexNumber = Integer.parseInt(st.nextToken());
        int edgeNumber = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int startVertex = Integer.parseInt(st.nextToken());
        int endVertex = Integer.parseInt(st.nextToken());

        List<List<Vertex>> graph = new ArrayList<>();
        for (int i = 0; i <= vertexNumber; i++) {
            graph.add(new ArrayList<>());
        }

        boolean[] visited = new boolean[vertexNumber + 1];

        for (int i = 0; i < edgeNumber; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(vertex1).add(new Vertex(vertex2, weight));
            graph.get(vertex2).add(new Vertex(vertex1, weight));
        }

        /* Prim */

        PriorityQueue<Vertex> pq = new PriorityQueue<>((vertex1, vertex2) -> vertex2.weight - vertex1.weight);
        pq.offer(new Vertex(startVertex, MAX_WEIGHT));

        int minimumWeight = MAX_WEIGHT;

        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            if (visited[currentVertex.number]) {
                continue;
            }

            visited[currentVertex.number] = true;

            minimumWeight = Math.min(minimumWeight, currentVertex.weight);

            if (currentVertex.number == endVertex) {
                break;
            }

            for (Vertex nextVertex : graph.get(currentVertex.number)) {
                if (visited[nextVertex.number]) {
                    continue;
                }

                pq.offer(nextVertex);
            }
        }

        bw.write(Integer.toString(visited[endVertex] ? minimumWeight : 0));

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
