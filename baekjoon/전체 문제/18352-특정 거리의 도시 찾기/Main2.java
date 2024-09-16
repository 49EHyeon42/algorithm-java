import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main2 {

    private static final Map<Integer, Set<Integer>> graph = new HashMap<>();
    private static final PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.distance));

    private static int[] minimumDistances;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        minimumDistances = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph.put(i, new HashSet<>());

            minimumDistances[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }

        dijkstra(X);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (minimumDistances[i] == K) {
                sb.append(i).append('\n');
            }
        }

        bw.write(sb.length() == 0 ? "-1" : sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void dijkstra(int startVertex) {
        pq.offer(new Vertex(startVertex, 0));
        minimumDistances[startVertex] = 0;

        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            if (minimumDistances[currentVertex.number] < currentVertex.distance) {
                continue;
            }

            for (int nextVertexNumber : graph.get(currentVertex.number)) {
                int nextVertexDistance = currentVertex.distance + 1;

                if (minimumDistances[nextVertexNumber] <= nextVertexDistance) {
                    continue;
                }

                pq.offer(new Vertex(nextVertexNumber, nextVertexDistance));
                minimumDistances[nextVertexNumber] = nextVertexDistance;
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
