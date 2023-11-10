import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.weight));

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            List<List<Vertex>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int vertex1 = Integer.parseInt(st.nextToken());
                int vertex2 = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                graph.get(vertex2).add(new Vertex(vertex1, weight));
            }

            int[] dijkstra = new int[n + 1];
            for (int j = 0; j <= n; j++) {
                dijkstra[j] = Integer.MAX_VALUE;
            }

            dijkstra[c] = 0;

            pq.offer(new Vertex(c, 0));

            while (!pq.isEmpty()) {
                Vertex currentVertex = pq.poll();

                for (Vertex nextVertex : graph.get(currentVertex.number)) {
                    if (dijkstra[nextVertex.number] > currentVertex.weight + nextVertex.weight) {
                        dijkstra[nextVertex.number] = currentVertex.weight + nextVertex.weight;

                        pq.offer(new Vertex(nextVertex.number, dijkstra[nextVertex.number]));
                    }
                }
            }

            int count = 0;
            int max = 0;

            for (int i : dijkstra) {
                if (i != Integer.MAX_VALUE) {
                    count++;

                    if (i > max) {
                        max = i;
                    }
                }
            }

            sb.append(count).append(' ').append(max).append('\n');
        }

        bw.write(sb.toString().trim());
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
