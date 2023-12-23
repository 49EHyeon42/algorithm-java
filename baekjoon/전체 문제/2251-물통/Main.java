import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int max = Math.max(A, Math.max(B, C));

        boolean[] visitedC = new boolean[C + 1];

        // bfs

        // [A][B][C]
        boolean[][][] visited = new boolean[max + 1][max + 1][max + 1];

        visited[0][0][C] = true;

        Queue<Status> queue = new ArrayDeque<>();

        queue.offer(new Status(0, 0, C));

        while (!queue.isEmpty()) {
            Status currentStatus = queue.poll();

            if (currentStatus.a == 0) {
                visitedC[currentStatus.c] = true;
            }

            // A to B, A to C
            if (currentStatus.a != 0) {
                // A to B
                if (currentStatus.a + currentStatus.b > B) { // 넘침
                    int nextA = currentStatus.a + currentStatus.b - B;

                    if (!visited[nextA][B][currentStatus.c]) {
                        visited[nextA][B][currentStatus.c] = true;

                        queue.offer(new Status(nextA, B, currentStatus.c));
                    }
                } else {
                    int nextB = currentStatus.a + currentStatus.b;

                    if (!visited[0][nextB][currentStatus.c]) {
                        visited[0][nextB][currentStatus.c] = true;

                        queue.offer(new Status(0, nextB, currentStatus.c));
                    }
                }

                // A to C
                if (currentStatus.a + currentStatus.c > C) { // 넘침
                    int nextA = currentStatus.a + currentStatus.c - C;

                    if (!visited[nextA][currentStatus.b][C]) {
                        visited[nextA][currentStatus.b][C] = true;

                        queue.offer(new Status(nextA, currentStatus.b, C));
                    }
                } else {
                    int nextC = currentStatus.a + currentStatus.c;

                    if (!visited[0][currentStatus.b][nextC]) {
                        visited[0][currentStatus.b][nextC] = true;

                        queue.offer(new Status(0, currentStatus.b, nextC));
                    }
                }
            }

            // B to A, B to C
            if (currentStatus.b != 0) {
                // B to A
                if (currentStatus.b + currentStatus.a > A) { // 넘침
                    int nextB = currentStatus.b + currentStatus.a - A;

                    if (!visited[A][nextB][currentStatus.c]) {
                        visited[A][nextB][currentStatus.c] = true;

                        queue.offer(new Status(A, nextB, currentStatus.c));
                    }
                } else {
                    int nextA = currentStatus.b + currentStatus.a;

                    if (!visited[nextA][0][currentStatus.c]) {
                        visited[nextA][0][currentStatus.c] = true;

                        queue.offer(new Status(nextA, 0, currentStatus.c));
                    }
                }

                // B to C
                if (currentStatus.b + currentStatus.c > C) { // 넘침
                    int nextB = currentStatus.b + currentStatus.c - C;

                    if (!visited[currentStatus.a][nextB][C]) {
                        visited[currentStatus.a][nextB][C] = true;

                        queue.offer(new Status(currentStatus.a, nextB, C));
                    }
                } else {
                    int nextC = currentStatus.b + currentStatus.c;

                    if (!visited[currentStatus.a][0][nextC]) {
                        visited[currentStatus.a][0][nextC] = true;

                        queue.offer(new Status(currentStatus.a, 0, nextC));
                    }
                }
            }

            // C to A, C to B
            if (currentStatus.c != 0) {
                // C to A
                if (currentStatus.c + currentStatus.a > A) { // 넘침
                    int nextC = currentStatus.c + currentStatus.a - A;

                    if (!visited[A][currentStatus.b][nextC]) {
                        visited[A][currentStatus.b][nextC] = true;

                        queue.offer(new Status(A, currentStatus.b, nextC));
                    }
                } else {
                    int nextA = currentStatus.c + currentStatus.a;

                    if (!visited[nextA][currentStatus.b][0]) {
                        visited[nextA][currentStatus.b][0] = true;

                        queue.offer(new Status(nextA, currentStatus.b, 0));
                    }
                }

                // C to B
                if (currentStatus.c + currentStatus.b > B) { // 넘침
                    int nextC = currentStatus.c + currentStatus.b - B;

                    if (!visited[currentStatus.a][B][nextC]) {
                        visited[currentStatus.a][B][nextC] = true;

                        queue.offer(new Status(currentStatus.a, B, nextC));
                    }
                } else {
                    int nextB = currentStatus.c + currentStatus.b;

                    if (!visited[currentStatus.a][nextB][0]) {
                        visited[currentStatus.a][nextB][0] = true;

                        queue.offer(new Status(currentStatus.a, nextB, 0));
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= C; i++) {
            if (visitedC[i]) {
                sb.append(i).append(' ');
            }
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static class Status {

        final int a;
        final int b;
        final int c;

        Status(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
