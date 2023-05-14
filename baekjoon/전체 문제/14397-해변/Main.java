import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dy = {-1, 0, 1, 1, 0, -1};
    private static final int[] dxOdd = {1, 1, 1, 0, -1, 0};
    private static final int[] dxEven = {0, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] graph = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String string = br.readLine();

            for (int j = 0; j < M; j++) {
                if (string.charAt(j) == '#') {
                    graph[i][j] = true;
                }
            }
        }

        int count = 0;

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (!graph[y][x]) {
                    continue;
                }

                for (int i = 0; i < 6; i++) {
                    int nextY = y + dy[i];
                    int nextX = x + ((y & 1) == 1 ? dxOdd[i] : dxEven[i]);

                    if (isPossible(N, M, nextY, nextX) && !graph[nextY][nextX]) {
                        count++;
                    }
                }
            }
        }

        bw.write(Integer.toString(count));
        bw.flush();

        br.close();
        bw.close();
    }

    private static boolean isPossible(int maxY, int maxX, int y, int x) {
        return 0 <= y && y < maxY && 0 <= x && x < maxX;
    }
}
