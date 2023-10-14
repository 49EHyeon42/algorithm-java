import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int vertexNumber = Integer.parseInt(br.readLine());

        List<List<Vertex>> graph = new ArrayList<>();
        for (int i = 0; i <= vertexNumber; i++) {
            graph.add(new ArrayList<>());
        }

        boolean[] visited = new boolean[vertexNumber + 1];

        for (int i = 1; i <= vertexNumber; i++) {
            int weight = Integer.parseInt(br.readLine());

            graph.get(0).add(new Vertex(i, weight));
            graph.get(i).add(new Vertex(0, weight));
        }

        for (int i = 1; i <= vertexNumber; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= vertexNumber; j++) {
                if (i <= j) {
                    break;
                }

                int weight = Integer.parseInt(st.nextToken());

                graph.get(i).add(new Vertex(j, weight));
                graph.get(j).add(new Vertex(i, weight));
            }
        }

        /* Prim */

        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.weight));
        pq.offer(new Vertex(0, 0));

        int minimumWeight = 0;

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

        bw.write(Integer.toString(minimumWeight));

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
