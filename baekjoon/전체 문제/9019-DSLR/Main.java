import java.io.*;
import java.util.*;

public class Main {

    private static final Set<Integer> visited = new HashSet<>();

    private static final Queue<Vertex> queue = new ArrayDeque<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            sb.append(bfs(A, B)).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static String bfs(int A, int B) {
        visited.clear();

        visited.add(A);

        queue.clear();

        queue.offer(new Vertex(null, A, '\0'));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            if (currentVertex.n == B) {
                StringBuilder sb = new StringBuilder();

                Vertex nextVertex = currentVertex;

                while (nextVertex.beforeVertex != null) {
                    sb.append(nextVertex.type);

                    nextVertex = nextVertex.beforeVertex;
                }

                return sb.reverse().toString();
            }

            // D
            int nextN = currentVertex.n * 2;

            if (nextN > 9999) {
                nextN %= 10000;
            }

            if (!visited.contains(nextN)) {
                visited.add(nextN);

                queue.offer(new Vertex(currentVertex, nextN, 'D'));
            }

            // S
            nextN = currentVertex.n - 1;

            if (nextN < 0) {
                nextN = 9999;
            }

            if (!visited.contains(nextN)) {
                visited.add(nextN);

                queue.offer(new Vertex(currentVertex, nextN, 'S'));
            }

            // config L, R
            int a = currentVertex.n / 1000;
            int b = (currentVertex.n % 1000) / 100;
            int c = (currentVertex.n % 100) / 10;
            int d = currentVertex.n % 10;

            // L
            nextN = b * 1000 + c * 100 + d * 10 + a;

            if (!visited.contains(nextN)) {
                visited.add(nextN);

                queue.offer(new Vertex(currentVertex, nextN, 'L'));
            }

            // R
            nextN = d * 1000 + a * 100 + b * 10 + c;

            if (!visited.contains(nextN)) {
                visited.add(nextN);

                queue.offer(new Vertex(currentVertex, nextN, 'R'));
            }
        }

        throw new RuntimeException();
    }

    private static class Vertex {

        final Vertex beforeVertex;
        final int n;
        final char type;

        Vertex(Vertex beforeVertex, int n, char type) {
            this.beforeVertex = beforeVertex;
            this.n = n;
            this.type = type;
        }
    }
}
