import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] sight = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            if (st.nextToken().equals("1")) {
                sight[i] = true;
            }
        }

        List<List<Vertex>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
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

        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingLong(vertex -> vertex.weight));

        long[] dijkstra = new long[N];
        Arrays.fill(dijkstra, Long.MAX_VALUE);

        dijkstra[0] = 0;

        pq.offer(new Vertex(0, 0));

        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            // 시간 초과 방지
            if (dijkstra[currentVertex.number] < currentVertex.weight) {
                continue;
            }

            if (currentVertex.number == N - 1) {
                break;
            }

            for (Vertex nextVertex : graph.get(currentVertex.number)) {
                if (!sight[nextVertex.number] && dijkstra[nextVertex.number] > currentVertex.weight + nextVertex.weight) {
                    dijkstra[nextVertex.number] = currentVertex.weight + nextVertex.weight;

                    pq.offer(new Vertex(nextVertex.number, dijkstra[nextVertex.number]));
                }
            }
        }

        bw.write(Long.toString(dijkstra[N - 1] == Long.MAX_VALUE ? -1 : dijkstra[N - 1]));
        bw.flush();

        br.close();
        bw.close();
    }

    private static class Vertex {

        final int number;
        final long weight;

        Vertex(int number, long weight) {
            this.number = number;
            this.weight = weight;
        }
    }
}
