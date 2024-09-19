import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    private static final Queue<Integer> queue = new LinkedList<>();

    private static int N;

    private static int[] graph;
    private static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        graph = new int[N];
        visited = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
            visited[i] = Integer.MAX_VALUE;
        }

        bw.write(Integer.toString(bfs()));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int bfs() {
        queue.offer(0);
        visited[0] = 0;

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            if (currentVertex == N - 1) {
                return visited[N - 1];
            }

            for (int i = 1; i <= graph[currentVertex]; i++) {
                int nextVertex = currentVertex + i;

                if (nextVertex >= N) {
                    continue;
                }

                if (visited[nextVertex] != Integer.MAX_VALUE) {
                    continue;
                }

                queue.offer(nextVertex);
                visited[nextVertex] = visited[currentVertex] + 1;
            }
        }

        return -1;
    }
}
