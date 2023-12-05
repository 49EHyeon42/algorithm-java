import java.io.*;
import java.util.*;

public class Main {

    private static final Queue<Vertex> queue = new ArrayDeque<>();

    private static int vertexNumber;
    private static List<List<Vertex>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            vertexNumber = n + 2;

            // [i][0] = x, [i][1] = y
            int[][] coordinates = new int[vertexNumber][2];

            for (int i = 0; i < vertexNumber; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                coordinates[i][0] = Integer.parseInt(st.nextToken());
                coordinates[i][1] = Integer.parseInt(st.nextToken());
            }

            graph = new ArrayList<>();
            for (int i = 0; i < vertexNumber; i++) {
                graph.add(new ArrayList<>());
            }

            for (int vertex1 = 0; vertex1 < vertexNumber - 1; vertex1++) {
                for (int vertex2 = vertex1 + 1; vertex2 < vertexNumber; vertex2++) {
                    int weight = Math.abs(coordinates[vertex1][0] - coordinates[vertex2][0]) +
                            Math.abs(coordinates[vertex1][1] - coordinates[vertex2][1]);

                    graph.get(vertex1).add(new Vertex(vertex2, weight));
                    graph.get(vertex2).add(new Vertex(vertex1, weight));
                }
            }

            sb.append(bfs()).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static String bfs() {
        queue.clear();

        boolean[] visited = new boolean[vertexNumber];
        visited[0] = true;

        queue.offer(new Vertex(0, 0));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            if (currentVertex.number == vertexNumber - 1) {
                return "happy";
            }

            for (Vertex nextVertex : graph.get(currentVertex.number)) {
                if (visited[nextVertex.number]) {
                    continue;
                }

                if (nextVertex.weight > 1000) {
                    continue;
                }

                visited[nextVertex.number] = true;

                queue.offer(nextVertex);
            }
        }

        return "sad";
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
