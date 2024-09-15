import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    private static final Map<Integer, Set<Integer>> graph = new HashMap<>();
    private static final Queue<Integer> queue = new LinkedList<>();

    private static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph.put(i, new HashSet<>());

            visited[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());

            graph.get(vertex1).add(vertex2);
            graph.get(vertex2).add(vertex1);
        }

        bfs();

        int vertex = 0;
        int distance = 0;
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (visited[i] > visited[vertex]) {
                vertex = i;
                distance = visited[i];
                count = 1;
            } else if (visited[i] == visited[vertex]) {
                count++;
            }
        }

        bw.write(vertex + " " + distance + " " + count);
        bw.flush();

        br.close();
        bw.close();
    }

    private static void bfs() {
        queue.offer(1);
        visited[1] = 0;

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            for (int nextVertex : graph.get(currentVertex)) {
                if (visited[nextVertex] != Integer.MAX_VALUE) {
                    continue;
                }

                queue.offer(nextVertex);
                visited[nextVertex] = visited[currentVertex] + 1;
            }
        }
    }
}
