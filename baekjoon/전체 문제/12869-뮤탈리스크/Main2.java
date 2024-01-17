import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {

    private static final int[] ns = new int[3];
    private static final int[] dx = {9, 3, 1};

    private static final boolean[][][] visited = new boolean[61][61][61];
    private static final Queue<Vertex> queue = new ArrayDeque<>();

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
        visited[ns[0]][ns[1]][ns[2]] = true;

        queue.offer(new Vertex(ns[0], ns[1], ns[2], 0));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            if (currentVertex.n0 == 0 && currentVertex.n1 == 0 && currentVertex.n2 == 0) {
                return currentVertex.weight;
            }

            permutation(0, 3, 3, currentVertex);
        }

        throw new RuntimeException();
    }

    // n개 중 r개 순열
    private static void permutation(int depth, int n, int r, Vertex currentVertex) {
        if (depth == r) {
            int nextN0 = Math.max(0, currentVertex.n0 - dx[0]);
            int nextN1 = Math.max(0, currentVertex.n1 - dx[1]);
            int nextN2 = Math.max(0, currentVertex.n2 - dx[2]);

            if (!visited[nextN0][nextN1][nextN2]) {
                visited[nextN0][nextN1][nextN2] = true;

                queue.offer(new Vertex(nextN0, nextN1, nextN2, currentVertex.weight + 1));
            }

            return;
        }

        for (int i = depth; i < n; i++) {
            swap(depth, i);
            permutation(depth + 1, n, r, currentVertex);
            swap(depth, i);
        }
    }

    private static void swap(int depth, int i) {
        int temp = dx[depth];
        dx[depth] = dx[i];
        dx[i] = temp;
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
