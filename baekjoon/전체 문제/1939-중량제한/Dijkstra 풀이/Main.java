import java.io.*;
import java.util.*;

public class Main {

    private static final Map<Integer, List<Vertex>> graph = new HashMap<>();

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph.get(A).add(new Vertex(B, C));
            graph.get(B).add(new Vertex(A, C));
        }

        st = new StringTokenizer(br.readLine());
        int startVertex = Integer.parseInt(st.nextToken());
        int endVertex = Integer.parseInt(st.nextToken());

        bw.write(Integer.toString(bfs(startVertex, endVertex)));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int bfs(int startVertex, int endVertex) {
        int[] visited = new int[N + 1];

        Arrays.fill(visited, Integer.MIN_VALUE);

        PriorityQueue<Vertex> pq = new PriorityQueue<>((vertex1, vertex2) -> vertex2.weight - vertex1.weight);

        visited[startVertex] = 0;

        pq.offer(new Vertex(startVertex, Integer.MAX_VALUE));

        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            if (visited[currentVertex.number] > currentVertex.weight) {
                continue;
            }

            for (Vertex nextVertex : graph.get(currentVertex.number)) {
                int nextWeight = Math.min(currentVertex.weight, nextVertex.weight);

                if (visited[nextVertex.number] < nextWeight) {
                    visited[nextVertex.number] = nextWeight;

                    if (nextVertex.number == endVertex) {
                        continue;
                    }

                    pq.offer(new Vertex(nextVertex.number, nextWeight));
                }
            }
        }

        return visited[endVertex];
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
