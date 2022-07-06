import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int width;
    private static int length;

    private static final int[] dy = {1, -1, 0, 0};
    private static final int[] dx = {0, 0, 1, -1};

    private static boolean[][] graph;
    private static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken());
            length = Integer.parseInt(st.nextToken());
            int cabbageCount = Integer.parseInt(st.nextToken());

            graph = new boolean[length + 1][width + 1];
            isVisited = new boolean[length + 1][width + 1];

            for (int j = 0; j < cabbageCount; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph[v][u] = true;
            }

            int count = 0;
            for (int j = 0; j <= length; j++) {
                for (int k = 0; k <= width; k++) {
                    if (graph[j][k] && !isVisited[j][k]) {
                        bfs(j, k);
                        count++;
                    }
                }
            }

            sb.append(count).append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    private static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{y, x});
        isVisited[y][x] = true;

        while (!queue.isEmpty()) {
            int currentY = queue.peek()[0];
            int currentX = queue.peek()[1];
            queue.poll();

            for (int k = 0; k < 4; k++) {
                int tempY = currentY + dy[k];
                int tempX = currentX + dx[k];

                if (isPossibleLength(tempY, tempX) &&
                    graph[tempY][tempX] && !isVisited[tempY][tempX]) {
                    queue.offer(new int[]{tempY, tempX});
                    isVisited[tempY][tempX] = true;
                }
            }
        }
    }

    private static boolean isPossibleLength(int y, int x) {
        return y >= 0 && x >= 0 && y < length && x < width;
    }
}
