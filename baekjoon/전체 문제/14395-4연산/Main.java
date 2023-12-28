import java.io.*;
import java.util.*;

public class Main {

    private static int s;
    private static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        bw.write(solution());
        bw.flush();

        br.close();
        bw.close();
    }

    private static String solution() {
        return s == t ? "0" : bfs();
    }

    private static String bfs() {
        Set<Long> visited = new HashSet<>();

        visited.add((long) s);

        Queue<Vertex> queue = new ArrayDeque<>();

        queue.offer(new Vertex(null, s, '0'));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            if (currentVertex.value == t) {
                StringBuilder sb = new StringBuilder();

                while (currentVertex.operator != '0') {
                    sb.append(currentVertex.operator);
                    currentVertex = currentVertex.beforeVertex;
                }

                return sb.reverse().toString();
            }

            // *
            long nextValue = currentVertex.value * currentVertex.value;

            if (nextValue > 0 && !visited.contains(nextValue)) {
                visited.add(nextValue);

                queue.offer(new Vertex(currentVertex, nextValue, '*'));
            }

            // +
            nextValue = currentVertex.value + currentVertex.value;

            if (nextValue > 0 && !visited.contains(nextValue)) {
                visited.add(nextValue);

                queue.offer(new Vertex(currentVertex, nextValue, '+'));
            }

            // - -> 항상 0 이기 떄문에 생략

            // / -> 항상 1
            if (!visited.contains(1L)) {
                visited.add(1L);

                queue.offer(new Vertex(currentVertex, 1, '/'));
            }
        }

        return "-1";
    }

    private static class Vertex {

        final Vertex beforeVertex;
        final long value;
        final char operator;

        Vertex(Vertex beforeVertex, long value, char operator) {
            this.beforeVertex = beforeVertex;
            this.value = value;
            this.operator = operator;
        }
    }
}
