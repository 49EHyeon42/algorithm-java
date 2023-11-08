import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Vertex>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(vertex1).add(new Vertex(vertex2, weight));
            graph.get(vertex2).add(new Vertex(vertex1, weight));
        }

        int[] dijkstra = new int[N + 1];
        Arrays.fill(dijkstra, Integer.MAX_VALUE);

        dijkstra[1] = 0;

        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.weight));
        pq.offer(new Vertex(1, 0));

        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            for (Vertex nextVertex : graph.get(currentVertex.number)) {
                if (dijkstra[nextVertex.number] > dijkstra[currentVertex.number] + nextVertex.weight) {
                    dijkstra[nextVertex.number] = dijkstra[currentVertex.number] + nextVertex.weight;

                    pq.offer(new Vertex(nextVertex.number, dijkstra[nextVertex.number]));
                }
            }
        }

        bw.write(Integer.toString(dijkstra[N]));
        bw.flush();

        br.close();
        bw.close();
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
