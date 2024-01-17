import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] ns = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            ns[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(Integer.toString(bfs()));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int bfs() {
        boolean[][][] visited = new boolean[61][61][61];

        Queue<Vertex> queue = new ArrayDeque<>();

        visited[ns[0]][ns[1]][ns[2]] = true;

        queue.offer(new Vertex(ns[0], ns[1], ns[2], 0));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            if (currentVertex.n0 == 0 && currentVertex.n1 == 0 && currentVertex.n2 == 0) {
                return currentVertex.weight;
            }

            int nextWeight = currentVertex.weight + 1;

            // case 1
            int nextN0 = Math.max(0, currentVertex.n0 - 9);
            int nextN1 = Math.max(0, currentVertex.n1 - 3);
            int nextN2 = Math.max(0, currentVertex.n2 - 1);

            if (!visited[nextN0][nextN1][nextN2]) {
                visited[nextN0][nextN1][nextN2] = true;

                queue.offer(new Vertex(nextN0, nextN1, nextN2, nextWeight));
            }

            // case 2
            nextN0 = Math.max(0, currentVertex.n0 - 9);
            nextN1 = Math.max(0, currentVertex.n1 - 1);
            nextN2 = Math.max(0, currentVertex.n2 - 3);

            if (!visited[nextN0][nextN1][nextN2]) {
                visited[nextN0][nextN1][nextN2] = true;

                queue.offer(new Vertex(nextN0, nextN1, nextN2, nextWeight));
            }

            // case 3
            nextN0 = Math.max(0, currentVertex.n0 - 3);
            nextN1 = Math.max(0, currentVertex.n1 - 9);
            nextN2 = Math.max(0, currentVertex.n2 - 1);

            if (!visited[nextN0][nextN1][nextN2]) {
                visited[nextN0][nextN1][nextN2] = true;

                queue.offer(new Vertex(nextN0, nextN1, nextN2, nextWeight));
            }

            // case 4
            nextN0 = Math.max(0, currentVertex.n0 - 3);
            nextN1 = Math.max(0, currentVertex.n1 - 1);
            nextN2 = Math.max(0, currentVertex.n2 - 9);

            if (!visited[nextN0][nextN1][nextN2]) {
                visited[nextN0][nextN1][nextN2] = true;

                queue.offer(new Vertex(nextN0, nextN1, nextN2, nextWeight));
            }

            // case 5
            nextN0 = Math.max(0, currentVertex.n0 - 1);
            nextN1 = Math.max(0, currentVertex.n1 - 9);
            nextN2 = Math.max(0, currentVertex.n2 - 3);

            if (!visited[nextN0][nextN1][nextN2]) {
                visited[nextN0][nextN1][nextN2] = true;

                queue.offer(new Vertex(nextN0, nextN1, nextN2, nextWeight));
            }

            // case 6
            nextN0 = Math.max(0, currentVertex.n0 - 1);
            nextN1 = Math.max(0, currentVertex.n1 - 3);
            nextN2 = Math.max(0, currentVertex.n2 - 9);

            if (!visited[nextN0][nextN1][nextN2]) {
                visited[nextN0][nextN1][nextN2] = true;

                queue.offer(new Vertex(nextN0, nextN1, nextN2, nextWeight));
            }
        }

        throw new RuntimeException();
    }

    private static class Vertex {

        final int n0;
        final int n1;
        final int n2;
        final int weight;

        Vertex(int n0, int n1, int n2, int weight) {
            this.n0 = n0;
            this.n1 = n1;
            this.n2 = n2;
            this.weight = weight;
        }
    }
}
