import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    private static final Visited[] visited = new Visited[61];
    private static final Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= 60; i++) {
            visited[i] = new Visited();
        }

        bfs();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            int quotient = N / 60;
            int remainder = N % 60;

            sb.append(visited[remainder].operators[0] + quotient).append(' ')
                    .append(visited[remainder].operators[1]).append(' ')
                    .append(visited[remainder].operators[2]).append(' ')
                    .append(visited[remainder].operators[3]).append(' ')
                    .append(visited[remainder].operators[4]).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void bfs() {
        visited[0].visited = true;

        queue.offer(0);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            for (Operator operator : Operator.values()) {
                int nextVertex = currentVertex + operator.value;

                if (nextVertex < 0 || nextVertex > 60) {
                    continue;
                }

                if (visited[nextVertex].visited) {
                    continue;
                }

                visited[nextVertex].visited = true;

                for (int j = 0; j < 5; j++) {
                    visited[nextVertex].operators[j] = visited[currentVertex].operators[j];
                }

                visited[nextVertex].operators[operator.index]++;

                queue.offer(nextVertex);
            }
        }
    }

    private static class Visited {

        boolean visited;
        int[] operators = new int[5];
    }

    private enum Operator {

        MINO(-1, 4), ADDO(1, 3), MINT(-10, 2), ADDT(10, 1), ADDH(60, 0);

        final int value;
        final int index;

        Operator(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
