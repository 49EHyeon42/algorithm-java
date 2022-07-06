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
    private static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        length = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        graph = new boolean[length][width];
        isVisited = new boolean[length][width];
        distance = new int[length][width];

        for (int i = 0; i < length; i++) {
            String string = br.readLine();
            for (int j = 0; j < width; j++) {
                graph[i][j] = string.charAt(j) != '0';
            }
        }

        bfs(0, 0);

        bw.write(Integer.toString(distance[length - 1][width - 1] + 1));

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
                    distance[tempY][tempX] = distance[currentY][currentX] + 1;
                }
            }
        }
    }

    private static boolean isPossibleLength(int y, int x) {
        return y >= 0 && x >= 0 && y < length && x < width;
    }
}
