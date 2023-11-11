import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Vertex>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(vertex1).add(new Vertex(vertex2, weight));
            graph.get(vertex2).add(new Vertex(vertex1, weight));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.weight));

        int[] dijkstra = new int[n + 1];
        Arrays.fill(dijkstra, Integer.MAX_VALUE);

        dijkstra[s] = 0;

        pq.offer(new Vertex(s, 0));

        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            // 시간 초과 방지
            if (dijkstra[currentVertex.number] < currentVertex.weight) {
                continue;
            }

            if (currentVertex.number == t) {
                break;
            }

            for (Vertex nextVertex : graph.get(currentVertex.number)) {
                if (dijkstra[nextVertex.number] > currentVertex.weight + nextVertex.weight) {
                    dijkstra[nextVertex.number] = currentVertex.weight + nextVertex.weight;

                    pq.offer(new Vertex(nextVertex.number, dijkstra[nextVertex.number]));
                }
            }
        }

        bw.write(Integer.toString(dijkstra[t]));
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
