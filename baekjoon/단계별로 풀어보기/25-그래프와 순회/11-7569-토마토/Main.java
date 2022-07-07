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
    private static int height;

    private static final int[] dz = {1, -1, 0, 0, 0, 0};
    private static final int[] dy = {0, 0, 1, -1, 0, 0};
    private static final int[] dx = {0, 0, 0, 0, 1, -1};

    private static int[][][] graph;

    private static final Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        width = Integer.parseInt(st.nextToken());
        length = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        graph = new int[height][length][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < length; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < width; k++) {
                    int temp = Integer.parseInt(st.nextToken());
                    if (temp == 1) {
                        queue.offer(new int[]{i, j, k});
                    }
                    graph[i][j][k] = temp;
                }
            }
        }

        bfs();

        int max = 0;
        boolean flag = false;
        Loop1:
        for (int[][] ints : graph) {
            for (int[] anInt : ints) {
                for (int x : anInt) {
                    if (x == 0) {
                        flag = true;
                        break Loop1;
                    }
                    if (max < x) {
                        max = x;
                    }
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
            int z = queue.peek()[0];
            int y = queue.peek()[1];
            int x = queue.peek()[2];
            queue.poll();

            for (int i = 0; i < 6; i++) {
                int currentZ = z + dz[i];
                int currentY = y + dy[i];
                int currentX = x + dx[i];

                if (isPossibleLength(currentZ, currentY, currentX)
                    && graph[currentZ][currentY][currentX] == 0) {
                    queue.offer(new int[]{currentZ, currentY, currentX});
                    graph[currentZ][currentY][currentX] = graph[z][y][x] + 1;
                }
            }
        }
    }

    private static boolean isPossibleLength(int z, int y, int x) {
        return z >= 0 && y >= 0 && x >= 0 && z < height && y < length && x < width;
    }
}
