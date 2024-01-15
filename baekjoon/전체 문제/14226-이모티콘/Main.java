import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(Integer.toString(bfs(Integer.parseInt(br.readLine()))));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int bfs(int S) {
        // y = value, x = clipboard
        boolean[][] visited = new boolean[1001][1001];

        visited[1][0] = true;

        Queue<Vertex> queue = new ArrayDeque<>();

        queue.offer(new Vertex(1, 0, 0));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            if (currentVertex.value == S) {
                return currentVertex.weight;
            }

            int nextWeight = currentVertex.weight + 1;

            // copy
            if (!visited[currentVertex.value][currentVertex.value]) {
                visited[currentVertex.value][currentVertex.clipboard] = true;

                queue.offer(new Vertex(currentVertex.value, currentVertex.value, nextWeight));
            }

            // paste
            if (currentVertex.clipboard > 0) {
                int nextValue = currentVertex.value + currentVertex.clipboard;

                if (nextValue < 1001 && !visited[nextValue][currentVertex.clipboard]) {
                    visited[nextValue][currentVertex.clipboard] = true;

                    queue.offer(new Vertex(nextValue, currentVertex.clipboard, nextWeight));
                }
            }

            // -1
            if (currentVertex.value > 0) {
                int nextValue = currentVertex.value - 1;

                if (!visited[nextValue][currentVertex.clipboard]) {
                    visited[nextValue][currentVertex.clipboard] = true;

                    queue.offer(new Vertex(nextValue, currentVertex.clipboard, nextWeight));
                }
            }
        }

        throw new RuntimeException();
    }

    private static class Vertex {

        final int value;
        final int clipboard;
        final int weight;

        Vertex(int value, int clipboard, int weight) {
            this.value = value;
            this.clipboard = clipboard;
            this.weight = weight;
        }
    }
}
