import java.io.*;
import java.util.*;

public class Main {

    private static final Map<Integer, Set<Vertex>> graph = new HashMap<>();
    private static final Map<Integer, Set<Integer>> deleteGraph = new HashMap<>();
    private static final PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.weight));
    private static final Queue<Integer> queue = new LinkedList<>();

    private static int N;

    private static boolean[][] status;

    private static int startVertex;
    private static int endVertex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0) {
                break;
            }

            graph.clear();
            deleteGraph.clear();

            for (int i = 0; i < N; i++) {
                graph.put(i, new HashSet<>());
                deleteGraph.put(i, new HashSet<>());
            }

            // false = 통과
            status = new boolean[N][N];

            st = new StringTokenizer(br.readLine());
            startVertex = Integer.parseInt(st.nextToken());
            endVertex = Integer.parseInt(st.nextToken());

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int U = Integer.parseInt(st.nextToken());
                int V = Integer.parseInt(st.nextToken());
                int P = Integer.parseInt(st.nextToken());

                graph.get(U).add(new Vertex(V, P));
            }

            dijkstra();

            bfs();

            int result = dijkstra();

            sb.append(result == Integer.MAX_VALUE ? -1 : result).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static int dijkstra() {
        int[] weights = new int[N];

        Arrays.fill(weights, Integer.MAX_VALUE);

        weights[startVertex] = 0;

        pq.offer(new Vertex(startVertex, 0));

        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            if (weights[currentVertex.number] < currentVertex.weight) {
                continue;
            }

            for (Vertex nextVertex : graph.get(currentVertex.number)) {
                if (status[currentVertex.number][nextVertex.number]) {
                    continue;
                }

                int nextWeight = currentVertex.weight + nextVertex.weight;

                if (weights[nextVertex.number] == nextWeight) {
                    deleteGraph.get(nextVertex.number).add(currentVertex.number);
                } else if (weights[nextVertex.number] > nextWeight) {
                    deleteGraph.get(nextVertex.number).clear();

                    deleteGraph.get(nextVertex.number).add(currentVertex.number);

                    weights[nextVertex.number] = nextWeight;

                    pq.offer(new Vertex(nextVertex.number, nextWeight));
                }
            }
        }

        return weights[endVertex];
    }

    private static void bfs() {
        boolean[] visited = new boolean[N];

        visited[endVertex] = true;

        queue.offer(endVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            for (int nextVertex : deleteGraph.get(currentVertex)) {
                status[nextVertex][currentVertex] = true;

                if (visited[nextVertex]) {
                    continue;
                }

                visited[nextVertex] = true;

                queue.offer(nextVertex);
            }
        }
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
