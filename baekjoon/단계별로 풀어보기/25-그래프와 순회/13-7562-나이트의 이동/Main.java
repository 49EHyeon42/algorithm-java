import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dy = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
    private static final int[] dx = new int[]{2, 1, -1, -2, -2, -1, 1, 2};

    private static int length;
    private static int[] startPosition;
    private static int[] endPosition;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            length = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            startPosition = new int[]{
                Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            st = new StringTokenizer(br.readLine());
            endPosition = new int[]{
                Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            sb.append(bfs()).append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        int[][] isVisited = new int[length][length];

        queue.offer(startPosition);
        isVisited[startPosition[0]][startPosition[1]] = 1;

        while (!queue.isEmpty()) {
            int[] currentPosition = queue.poll();

            if (currentPosition[0] == endPosition[0] && currentPosition[1] == endPosition[1]) {
                return isVisited[currentPosition[0]][currentPosition[1]] - 1;
            }

            for (int i = 0; i < 8; i++) {
                int y = currentPosition[0] + dy[i];
                int x = currentPosition[1] + dx[i];

                if (isPossibleLength(y, x) && isVisited[y][x] == 0) {
                    isVisited[y][x] = isVisited[currentPosition[0]][currentPosition[1]] + 1;
                    queue.offer(new int[]{y, x});
                }
            }
        }

        return -1;
    }

    private static boolean isPossibleLength(int y, int x) {
        return y >= 0 && x >= 0 && y < length && x < length;
    }
}
