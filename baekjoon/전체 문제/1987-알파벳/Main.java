import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dy = {1, -1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};

    private static int R;
    private static int C;

    private static String[] graph;
    private static final boolean[] visited = new boolean[26];

    private static int maxCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new String[R];

        for (int i = 0; i < R; i++) {
            graph[i] = br.readLine();
        }

        visited[graph[0].charAt(0) - 65] = true;

        backtracking(0, 0, 1);

        bw.write(Integer.toString(maxCount));
        bw.flush();

        br.close();
        bw.close();
    }

    private static void backtracking(int y, int x, int count) {
        maxCount = Math.max(maxCount, count);

        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (!isPossibleRange(nextY, nextX) || visited[graph[nextY].charAt(nextX) - 65]) {
                continue;
            }

            visited[graph[nextY].charAt(nextX) - 65] = true;

            backtracking(nextY, nextX, count + 1);

            visited[graph[nextY].charAt(nextX) - 65] = false;
        }
    }

    private static boolean isPossibleRange(int y, int x) {
        return 0 <= y && y < R && 0 <= x && x < C;
    }
}
