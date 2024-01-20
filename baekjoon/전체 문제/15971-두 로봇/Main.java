import java.io.*;
import java.util.*;

public class Main {

    private static final Map<Integer, List<Vertex>> graph = new HashMap<>();
    private static final Queue<Vertex> queue = new ArrayDeque<>();

    private static int N;
    private static int start;
    private static int end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(vertex1).add(new Vertex(vertex2, weight, -1));
            graph.get(vertex2).add(new Vertex(vertex1, weight, -1));
        }

        bw.write(Integer.toString(bfs()));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int bfs() {
        if (start == end) {
            return 0;
        }

        boolean[] visited = new boolean[N + 1];

        visited[start] = true;

        queue.offer(new Vertex(start, 0, -1));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            if (currentVertex.number == end) {
                return currentVertex.weight - currentVertex.max;
            }

            for (Vertex nextVertex : graph.get(currentVertex.number)) {
                if (visited[nextVertex.number]) {
                    continue;
                }

                visited[nextVertex.number] = true;

                int nextMax = Math.max(currentVertex.max, nextVertex.weight);

                queue.offer(new Vertex(nextVertex.number, currentVertex.weight + nextVertex.weight, nextMax));
            }
        }

        throw new RuntimeException();
    }

    private static class Vertex {

        final int number;
        final int weight;
        final int max;

        Vertex(int number, int weight, int max) {
            this.number = number;
            this.weight = weight;
            this.max = max;
        }
    }
}
