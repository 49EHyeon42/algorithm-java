import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        List<List<Vertex>> graph = new ArrayList<>();

        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(weight -> weight.weight));

        while (T-- > 0) {
            graph.clear();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            for (int i = 0; i <= N; i++) {
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

            int K = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            int[] friends = new int[K];
            for (int i = 0; i < K; i++) {
                friends[i] = Integer.parseInt(st.nextToken());
            }

            int result = 0;
            int minWeight = Integer.MAX_VALUE;

            for (int startVertex = 1; startVertex <= N; startVertex++) {
                int[] dijkstra = new int[N + 1];
                for (int i = 0; i <= N; i++) {
                    dijkstra[i] = Integer.MAX_VALUE;
                }

                dijkstra[startVertex] = 0;

                pq.offer(new Vertex(startVertex, 0));

                while (!pq.isEmpty()) {
                    Vertex currentVertex = pq.poll();

                    if (dijkstra[currentVertex.number] < currentVertex.weight) {
                        continue;
                    }

                    for (Vertex nextVertex : graph.get(currentVertex.number)) {
                        if (dijkstra[nextVertex.number] > dijkstra[currentVertex.number] + nextVertex.weight) {
                            dijkstra[nextVertex.number] = dijkstra[currentVertex.number] + nextVertex.weight;

                            pq.offer(new Vertex(nextVertex.number, dijkstra[nextVertex.number]));
                        }
                    }
                }

                int totalWeight = 0;

                for (int friend : friends) {
                    totalWeight += dijkstra[friend];
                }

                if (minWeight > totalWeight) {
                    result = startVertex;
                    minWeight = totalWeight;
                }
            }

            sb.append(result).append('\n');
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
