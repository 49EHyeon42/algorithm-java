
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int numberOfVertices = Integer.parseInt(br.readLine());

        List<List<Vertex>> graph = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= numberOfVertices; i++) {
            graph.add(new ArrayList<>());
            result.add(new ArrayList<>());
        }

        for (int i = 1; i < numberOfVertices; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1 + i; j <= numberOfVertices; j++) {
                int weight = Integer.parseInt(st.nextToken());

                graph.get(i).add(new Vertex(i, j, weight));
                graph.get(j).add(new Vertex(j, i, weight));
            }
        }

        // Prim

        boolean[] visited = new boolean[numberOfVertices + 1];

        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.weight));

        // start vertex = 1
        pq.offer(new Vertex(-1, 1, 0));

        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            if (visited[currentVertex.to]) {
                continue;
            }

            visited[currentVertex.to] = true;

            if (currentVertex.from != -1) {
                result.get(currentVertex.from).add(currentVertex.to);
                result.get(currentVertex.to).add(currentVertex.from);
            }

            for (Vertex nextVertex : graph.get(currentVertex.to)) {
                if (visited[nextVertex.to]) {
                    continue;
                }

                pq.offer(nextVertex);
            }
        }

        for (int i = 1; i <= numberOfVertices; i++) {
            result.get(i).sort(Comparator.comparingInt(vertex -> vertex));

            sb.append(result.get(i).size());

            for (int j : result.get(i)) {
                sb.append(" ").append(j);
            }

            sb.append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    private static class Vertex {

        final int from;
        final int to;
        final int weight;

        Vertex(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
