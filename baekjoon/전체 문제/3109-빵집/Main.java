import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final int[][] dyx = {{-1, 1}, {0, 1}, {1, 1}};

    private static int R;
    private static int C;

    private static boolean[][] graph;
    private static boolean[][] visited;

    private static int count;

    private static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String string = br.readLine();

            for (int j = 0; j < C; j++) {
                graph[i][j] = string.charAt(j) == 'x';
            }
        }

        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            flag = false;

            backtracking(i, 0);
        }

        bw.write(Integer.toString(count));
        bw.flush();

        br.close();
        bw.close();
    }

    private static void backtracking(int y, int x) {
        if (x == C - 1) {
            count++;

            flag = true;

            return;
        }

        for (int i = 0; i < 3; i++) {
            int nextY = y + dyx[i][0];
            int nextX = x + dyx[i][1];

            if (nextY < 0 || nextY >= R || nextX < 0 || nextX >= C) {
                continue;
            }

            if (graph[nextY][nextX]) {
                continue;
            }

            if (visited[nextY][nextX]) {
                continue;
            }

            if (flag) { // 다른 경로에서 발견한 경우(최단), 더 이상 진행하지 앟음
                continue;
            }

            visited[nextY][nextX] = true;

            backtracking(nextY, nextX);
        }
    }
}
