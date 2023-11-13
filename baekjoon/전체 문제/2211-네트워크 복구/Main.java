import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Set<Vertex>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new HashSet<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(vertex1).add(new Vertex(vertex2, weight));
            graph.get(vertex2).add(new Vertex(vertex1, weight));
        }

        // [0] = total weight, [1] = parent Vertex
        int[][] table = new int[graph.size()][2];
        for (int i = 0; i < graph.size(); i++) {
            table[i][0] = Integer.MAX_VALUE;
            table[i][1] = i;
        }

        table[1][0] = 0;

        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.weight));
        pq.offer(new Vertex(1, 0));

        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            if (table[currentVertex.number][0] < currentVertex.weight) {
                continue;
            }

            for (Vertex nextVertex : graph.get(currentVertex.number)) {
                if (table[nextVertex.number][0] > table[currentVertex.number][0] + nextVertex.weight) {
                    table[nextVertex.number][0] = table[currentVertex.number][0] + nextVertex.weight;
                    table[nextVertex.number][1] = currentVertex.number;

                    pq.offer(new Vertex(nextVertex.number, table[nextVertex.number][0]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(N - 1); // always

        for (int i = 2; i < table.length; i++) {
            sb.append('\n').append(i).append(' ').append(table[i][1]);
        }

        bw.write(sb.toString());
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
