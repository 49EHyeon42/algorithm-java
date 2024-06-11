import java.io.*;
import java.util.StringTokenizer;

public class Main {

    // 하 -> 우 -> 상 -> 좌
    private static final int[][] dyx = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private static int[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        array = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int minLength = Math.min(N, M);

        int currentStart = 0;
        int currentEndY = N;
        int currentEndX = M;

        while (minLength-- > 0) {
            for (int i = 0; i < R; i++) {
                rotate(currentStart, currentStart, currentEndY, currentEndX);
            }

            currentStart++;
            currentEndY--;
            currentEndX--;
        }

        StringBuilder sb = new StringBuilder();

        for (int[] ints : array) {
            for (int i : ints) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void rotate(int startY, int startX, int endY, int endX) {
        int way = 0;

        int currentY = startY;
        int currentX = startX;

        int previousValue = array[currentY][currentX];

        while (way < 4) {
            int nextY = currentY + dyx[way][0];
            int nextX = currentX + dyx[way][1];

            if (nextY < startY || nextY >= endY || nextX < startX || nextX >= endX) {
                way++;
                continue;
            }

            int temp = array[nextY][nextX];

            array[nextY][nextX] = previousValue;

            previousValue = temp;

            currentY = nextY;
            currentX = nextX;
        }
    }
}
