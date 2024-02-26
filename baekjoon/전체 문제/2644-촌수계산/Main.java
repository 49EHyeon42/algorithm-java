import java.io.*;
import java.util.*;

public class Main {

    private static Map<Integer, List<Integer>> graph;
    private static int[] visited;

    private static int start;
    private static int end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        visited = new int[n + 1];
        Arrays.fill(visited, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        bw.write(Integer.toString(bfs()));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int bfs() {
        Queue<Integer> queue = new ArrayDeque<>();

        visited[start] = 0;

        queue.offer(start);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            if (currentVertex == end) {
                return visited[end];
            }

            for (int nextVertex : graph.get(currentVertex)) {
                if (visited[nextVertex] != -1) {
                    continue;
                }

                visited[nextVertex] = visited[currentVertex] + 1;

                queue.offer(nextVertex);
            }
        }

        return -1;
    }
}
