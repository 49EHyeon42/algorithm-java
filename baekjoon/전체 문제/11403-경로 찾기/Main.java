import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N;

    private static boolean[][] graph;
    private static boolean[] visit;

    private static final Queue<Integer> queue = new LinkedList<>();

    private static void bfs(int vertex) {
        queue.clear();

        queue.offer(vertex);

        while (!queue.isEmpty()) {
            int nextVertex = queue.poll();

            for (int i = 0; i < N; i++) {
                if (graph[nextVertex][i] && !visit[i]) {
                    visit[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        graph = new boolean[N][N];

        for (int y = 0; y < N; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int x = 0; x < N; x++) {
                if (st.nextToken().equals("1")) {
                    graph[y][x] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            visit = new boolean[N];

            bfs(i);

            for (int j = 0; j < N; j++) {
                sb.append(visit[j] ? 1 : 0).append(' ');
            }

            sb.append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }
}
