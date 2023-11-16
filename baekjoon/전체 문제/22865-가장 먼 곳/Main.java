import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<List<Vertex>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        // [0] = A, [1] = B, [2] = C
        int[] friends = new int[3];
        for (int i = 0; i < 3; i++) {
            friends[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(vertex1).add(new Vertex(vertex2, weight));
            graph.get(vertex2).add(new Vertex(vertex1, weight));
        }

        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(weight -> weight.weight));

        int[] array = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            array[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < 3; i++) {
            int startVertex = friends[i];

            int[] dijkstra = new int[N + 1];
            for (int j = 0; j <= N; j++) {
                dijkstra[j] = Integer.MAX_VALUE;
            }

            dijkstra[startVertex] = 0;

            pq.offer(new Vertex(startVertex, 0));

            while (!pq.isEmpty()) {
                Vertex currentVertex = pq.poll();

                if (dijkstra[currentVertex.number] < currentVertex.weight) {
                    continue;
                }

                for (Vertex nextVertex : graph.get(currentVertex.number)) {
                    int nextWeight = dijkstra[currentVertex.number] + nextVertex.weight;

                    if (dijkstra[nextVertex.number] > nextWeight) {
                        dijkstra[nextVertex.number] = nextWeight;

                        pq.offer(new Vertex(nextVertex.number, nextWeight));
                    }
                }
            }

            for (int j = 1; j <= N; j++) {
                if (array[j] > dijkstra[j]) {
                    array[j] = dijkstra[j];
                }
            }
        }

        int index = -1;
        int value = -1;

        for (int i = 1; i <= N; i++) {
            if (value < array[i]) {
                index = i;
                value = array[i];
            }
        }

        bw.write(Integer.toString(index));
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
