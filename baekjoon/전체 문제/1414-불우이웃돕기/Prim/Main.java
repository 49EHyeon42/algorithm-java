import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int vertexNumber = Integer.parseInt(br.readLine());

        List<List<Vertex>> graph = new ArrayList<>();
        for (int i = 0; i < vertexNumber; i++) {
            graph.add(new ArrayList<>());
        }

        boolean[] visited = new boolean[vertexNumber];

        long totalWeight = 0;

        for (int i = 0; i < vertexNumber; i++) {
            String string = br.readLine();

            for (int j = 0; j < vertexNumber; j++) {
                char c = string.charAt(j);

                int weight;
                if ('a' <= c && c <= 'z') {
                    weight = c - 96;
                } else if ('A' <= c && c <= 'Z') {
                    weight = c - 38;
                } else { // c == '0'
                    weight = 0;
                }

                totalWeight += weight;

                if (weight == 0 || i == j) {
                    continue;
                }

                graph.get(i).add(new Vertex(j, weight));
                graph.get(j).add(new Vertex(i, weight));
            }
        }

        /* Prim */

        long minimumWeight = 0;

        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.weight));

        pq.offer(new Vertex(0, 0));

        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            if (visited[currentVertex.number]) {
                continue;
            }

            minimumWeight += currentVertex.weight;

            visited[currentVertex.number] = true;

            for (Vertex nextVertex : graph.get(currentVertex.number)) {
                if (visited[nextVertex.number]) {
                    continue;
                }

                pq.offer(nextVertex);
            }
        }


        bw.write(Long.toString(isVisitedAll(visited) ? totalWeight - minimumWeight : -1));

        bw.flush();
        bw.close();
    }

    private static boolean isVisitedAll(boolean[] visited) {
        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }

        return true;
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
