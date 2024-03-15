import java.io.*;
import java.util.*;

public class Main {

    private static final Map<Integer, Set<Vertex>> graph = new HashMap<>();

    private static int D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= D; i++) {
            graph.put(i, new HashSet<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int startVertex = Integer.parseInt(st.nextToken());
            int endVertex = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if (endVertex > D) {
                continue;
            }

            if (endVertex - startVertex <= weight) {
                continue;
            }

            graph.get(startVertex).add(new Vertex(endVertex, weight));
        }

        bw.write(Integer.toString(dijkstra()));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int dijkstra() {
        int[] visited = new int[D + 1];

        Arrays.fill(visited, Integer.MAX_VALUE);

        visited[0] = 0;

        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.weight));

        pq.offer(new Vertex(0, 0));

        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            if (visited[currentVertex.number] < currentVertex.weight) {
                continue;
            }

            for (Vertex nextVertex : graph.get(currentVertex.number)) {
                int nextWeight = currentVertex.weight + nextVertex.weight;

                if (visited[nextVertex.number] <= nextWeight) {
                    continue;
                }

                visited[nextVertex.number] = nextWeight;

                pq.offer(new Vertex(nextVertex.number, nextWeight));
            }

            if (currentVertex.number >= D) {
                continue;
            }

            int nextNumber = currentVertex.number + 1;
            int nextWeight = currentVertex.weight + 1;

            if (visited[nextNumber] <= nextWeight) {
                continue;
            }

            visited[nextNumber] = nextWeight;

            pq.offer(new Vertex(nextNumber, nextWeight));
        }

        return visited[D];
    }

    private static class Vertex {

        int number;
        int weight;

        Vertex(int number, int weight) {
            this.number = number;
            this.weight = weight;
        }
    }
}
