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

    private static int[][] graph;

    private static final Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        width = Integer.parseInt(st.nextToken());
        length = Integer.parseInt(st.nextToken());

        graph = new int[length][width];

        for (int i = 0; i < length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 1) {
                    queue.offer(new int[]{i, j});
                }
                graph[i][j] = temp;
            }
        }

        bfs();

        int max = 0;
        boolean flag = false;
        Loop1:
        for (int[] ints : graph) {
            for (int x : ints) {
                if (x == 0) {
                    flag = true;
                    break Loop1;
                }
                if (max < x) {
                    max = x;
                }
            }
        }

        int answer = (flag) ? -1 : max - 1;

        bw.write(Integer.toString(answer));

        bw.flush();
        bw.close();
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int y = queue.peek()[0];
            int x = queue.peek()[1];
            queue.poll();

            for (int k = 0; k < 4; k++) {
                int currentY = y + dy[k];
                int currentX = x + dx[k];

                if (isPossibleLength(currentY, currentX) && graph[currentY][currentX] == 0) {
                    queue.offer(new int[]{currentY, currentX});
                    graph[currentY][currentX] = graph[y][x] + 1;
                }
            }
        }
    }

    private static boolean isPossibleLength(int y, int x) {
        return y >= 0 && x >= 0 && y < length && x < width;
    }
}
