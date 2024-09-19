import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    private static final Map<Integer, Set<Vertex>> graph = new HashMap<>();
    private static final PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.distance));

    private static int[] minimumDistances;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        minimumDistances = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph.put(i, new HashSet<>());

            minimumDistances[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            graph.get(vertex1).add(new Vertex(vertex2, distance));
            graph.get(vertex2).add(new Vertex(vertex1, distance));
        }

        dijkstra();

        bw.write(Integer.toString(minimumDistances[N]));
        bw.flush();

        br.close();
        bw.close();
    }

    private static void dijkstra() {
        pq.offer(new Vertex(1, 0));
        minimumDistances[1] = 0;

        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            if (minimumDistances[currentVertex.number] < currentVertex.distance) {
                continue;
            }

            for (Vertex nextVertex : graph.get(currentVertex.number)) {
                int nextVertexDistance = currentVertex.distance + nextVertex.distance;

                if (minimumDistances[nextVertex.number] <= nextVertexDistance) {
                    continue;
                }

                pq.offer(new Vertex(nextVertex.number, nextVertexDistance));
                minimumDistances[nextVertex.number] = nextVertexDistance;
            }
        }
    }

    private static class Vertex {

        final int number;
        final int distance;

        Vertex(int number, int distance) {
            this.number = number;
            this.distance = distance;
        }
    }
}
