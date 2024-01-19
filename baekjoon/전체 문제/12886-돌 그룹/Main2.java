import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 해를 찾을 수 있을 것 같으나, 메모리 초과 코드
public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        bw.write(Integer.toString(bfs(A, B, C)));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int bfs(int A, int B, int C) {
        int max = A + B + C - 1;

        boolean[][][] visited = new boolean[max][max][max];

        Queue<Vertex> queue = new ArrayDeque<>();

        visited[A][B][C] = true;

        queue.offer(new Vertex(A, B, C));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            if (currentVertex.a == currentVertex.b && currentVertex.b == currentVertex.c) {
                return 1;
            }

            int nextX;
            int nextY;

            if (currentVertex.a != currentVertex.b) {
                if (currentVertex.a > currentVertex.b) {
                    nextX = currentVertex.b + currentVertex.b;
                    nextY = currentVertex.a - currentVertex.b;

                    if (!visited[nextY][nextX][currentVertex.c]) {
                        visited[nextY][nextX][currentVertex.c] = true;

                        queue.offer(new Vertex(nextY, nextX, currentVertex.c));
                    }
                } else {
                    nextX = currentVertex.a + currentVertex.a;
                    nextY = currentVertex.b - currentVertex.a;

                    if (!visited[nextX][nextY][currentVertex.c]) {
                        visited[nextX][nextY][currentVertex.c] = true;

                        queue.offer(new Vertex(nextX, nextY, currentVertex.c));
                    }
                }
            }

            if (currentVertex.a != currentVertex.c) {
                if (currentVertex.a > currentVertex.c) {
                    nextX = currentVertex.c + currentVertex.c;
                    nextY = currentVertex.a - currentVertex.c;

                    if (!visited[nextY][currentVertex.b][nextX]) {
                        visited[nextY][currentVertex.b][nextX] = true;

                        queue.offer(new Vertex(nextY, currentVertex.b, nextX));
                    }
                } else {
                    nextX = currentVertex.a + currentVertex.a;
                    nextY = currentVertex.c - currentVertex.a;

                    if (!visited[nextX][currentVertex.b][nextY]) {
                        visited[nextX][currentVertex.b][nextY] = true;

                        queue.offer(new Vertex(nextX, currentVertex.b, nextY));
                    }
                }
            }

            if (currentVertex.b != currentVertex.c) {
                if (currentVertex.b > currentVertex.c) {
                    nextX = currentVertex.c + currentVertex.c;
                    nextY = currentVertex.b - currentVertex.c;

                    if (!visited[currentVertex.a][nextY][nextX]) {
                        visited[currentVertex.a][nextY][nextX] = true;

                        queue.offer(new Vertex(currentVertex.a, nextY, nextX));
                    }
                } else {
                    nextX = currentVertex.b + currentVertex.b;
                    nextY = currentVertex.c - currentVertex.b;

                    if (!visited[currentVertex.a][nextX][nextY]) {
                        visited[currentVertex.a][nextX][nextY] = true;

                        queue.offer(new Vertex(currentVertex.a, nextX, nextY));
                    }
                }
            }
        }

        return 0;
    }

    private static class Vertex {

        final int a;
        final int b;
        final int c;

        Vertex(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
