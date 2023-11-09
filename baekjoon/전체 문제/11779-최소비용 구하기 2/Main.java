import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<List<Vertex>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            graph.get(Integer.parseInt(st.nextToken())).add(new Vertex(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startVertex = Integer.parseInt(st.nextToken());
        int endVertex = Integer.parseInt(st.nextToken());

        int[] dijkstra = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dijkstra[i] = Integer.MAX_VALUE;
        }

        dijkstra[0] = 0;

        int count = 1;
        String path = Integer.toString(startVertex);

        PriorityQueue<Vertex2> pq = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.weight));
        pq.offer(new Vertex2(startVertex, 0, count, path));

        while (!pq.isEmpty()) {
            Vertex2 currentVertex = pq.poll();

            if (currentVertex.number == endVertex) {
                count = currentVertex.count;
                path = currentVertex.path;
                break;
            }

            for (Vertex nextVertex : graph.get(currentVertex.number)) {
                if (dijkstra[nextVertex.number] > currentVertex.weight + nextVertex.weight) {
                    dijkstra[nextVertex.number] = currentVertex.weight + nextVertex.weight;

                    pq.offer(new Vertex2(nextVertex.number, dijkstra[nextVertex.number], currentVertex.count + 1, currentVertex.path + " " + nextVertex.number));
                }
            }
        }

        bw.write(Integer.toString(dijkstra[endVertex]) + '\n' + count + '\n' + path);
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

    private static class Vertex2 {

        final int number;
        final int weight;
        final int count;
        final String path;

        Vertex2(int number, int weight, int count, String path) {
            this.number = number;
            this.weight = weight;
            this.count = count;
            this.path = path;
        }
    }
}
