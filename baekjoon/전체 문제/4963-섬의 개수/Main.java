import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    private static final int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

    private static int height;
    private static int width;

    private static boolean[][] graph;
    private static boolean[][] visit;

    private static void recursiveDFS(int y, int x) {
        visit[y][x] = true;

        for (int i = 0; i < 8; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (isPossible(nextY, nextX) && graph[nextY][nextX] && !visit[nextY][nextX]) {
                recursiveDFS(nextY, nextX);
            }
        }
    }

    private static final Stack<int[]> stack = new Stack<>();

    private static void iterativeDFS(int y, int x) {
        stack.clear();

        stack.push(new int[]{y, x});

        while (!stack.isEmpty()) {
            int[] coordinate = stack.pop();

            for (int i = 0; i < 8; i++) {
                int nextY = coordinate[0] + dy[i];
                int nextX = coordinate[1] + dx[i];

                if (isPossible(nextY, nextX) && graph[nextY][nextX] && !visit[nextY][nextX]) {
                    recursiveDFS(nextY, nextX);
                }
            }
        }
    }

    private static boolean isPossible(int y, int x) {
        return 0 <= y && y < height && 0 <= x && x < width;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());

            if (height == 0 && width == 0) {
                break;
            }

            graph = new boolean[height][width];
            visit = new boolean[height][width];

            int count = 0;

            for (int y = 0; y < height; y++) {
                st = new StringTokenizer(br.readLine());

                for (int x = 0; x < width; x++) {
                    graph[y][x] = Integer.parseInt(st.nextToken()) != 0;
                }
            }

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (graph[y][x] && !visit[y][x]) {
                        count++;

                        iterativeDFS(y, x);
                    }
                }
            }

            sb.append(count).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }
}
