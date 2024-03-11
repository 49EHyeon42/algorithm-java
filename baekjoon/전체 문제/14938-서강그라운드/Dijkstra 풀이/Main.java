import java.io.*;
import java.util.*;

public class Main {

    private static final Map<Integer, Set<Vertex>> graph = new HashMap<>();
    private static final PriorityQueue<Vertex> pq = new PriorityQueue<>((vertex1, vertex2) -> vertex2.weight - vertex1.weight);

    private static int n;
    private static int m;
    private static int[] items;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        items = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            graph.put(i, new HashSet<>());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Vertex(b, l));
            graph.get(b).add(new Vertex(a, l));
        }

        int max = 0;

        for (int i = 1; i <= n; i++) {
            int item = dijkstra(i);

            if (max < item) {
                max = item;
            }
        }

        bw.write(Integer.toString(max));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int dijkstra(int startVertex) {
        int[] visited = new int[n + 1];

        Arrays.fill(visited, Integer.MAX_VALUE);

        visited[startVertex] = 0;

        pq.offer(new Vertex(startVertex, 0));

        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            for (Vertex nextVertex : graph.get(currentVertex.number)) {
                int nextWeight = currentVertex.weight + nextVertex.weight;

                if (nextWeight > m) {
                    continue;
                }

                if (visited[nextVertex.number] <= nextWeight) {
                    continue;
                }

                visited[nextVertex.number] = nextWeight;

                pq.offer(new Vertex(nextVertex.number, nextWeight));
            }
        }

        int item = 0;

        for (int i = 1; i <= n; i++) {
            if (visited[i] == Integer.MAX_VALUE) {
                continue;
            }

            item += items[i];
        }

        return item;
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
