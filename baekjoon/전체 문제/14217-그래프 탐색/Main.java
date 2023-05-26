import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int n;

    private static boolean[][] graph;

    private static final Queue<int[]> queue = new LinkedList<>();

    private static int[] bfs() {
        queue.clear();

        int[] visit = new int[n];
        for (int i = 1; i < n; i++) {
            visit[i] = -1;
        }

        // [0] = next city, [1] = minimum move distance
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < n; i++) {
                if (graph[current[0]][i] && visit[i] == -1) {
                    visit[i] = current[1] + 1;
                    queue.offer(new int[]{i, visit[i]});
                }
            }
        }

        return visit;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new boolean[n][n];

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int city1 = Integer.parseInt(st.nextToken()) - 1;
            int city2 = Integer.parseInt(st.nextToken()) - 1;

            graph[city1][city2] = graph[city2][city1] = true;
        }

        int q = Integer.parseInt(br.readLine());

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;

            graph[i][j] = graph[j][i] = a == 1;

            for (int min : bfs()) {
                sb.append(min).append(' ');
            }
            sb.append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }
}
