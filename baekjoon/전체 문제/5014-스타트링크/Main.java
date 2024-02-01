import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken()) - 1;
        int G = Integer.parseInt(st.nextToken()) - 1;
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        bw.write(bfs(new boolean[F], new ArrayDeque<>(), F, S, G, U, D));
        bw.flush();

        br.close();
        bw.close();
    }

    private static String bfs(boolean[] visited, Queue<Vertex> queue, int F, int S, int G, int U, int D) {
        visited[S] = true;

        queue.offer(new Vertex(S, 0));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            if (currentVertex.number == G) {
                return Integer.toString(currentVertex.weight);
            }

            // up
            int nextVertex = currentVertex.number + U;

            if (nextVertex < F) {
                if (!visited[nextVertex]) {
                    visited[nextVertex] = true;

                    queue.offer(new Vertex(nextVertex, currentVertex.weight + 1));
                }
            }

            // down
            nextVertex = currentVertex.number - D;

            if (nextVertex > -1) {
                if (!visited[nextVertex]) {
                    visited[nextVertex] = true;

                    queue.offer(new Vertex(nextVertex, currentVertex.weight + 1));
                }
            }
        }

        return "use the stairs";
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
