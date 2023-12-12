import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dy = new int[]{-1, 1, 0, 0};
    private static final int[] dx = new int[]{0, 0, -1, 1};

    private static final Queue<Coordinate> queue = new ArrayDeque<>();

    private static int width;
    private static int length;
    private static char[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        width = Integer.parseInt(st.nextToken());
        length = Integer.parseInt(st.nextToken());

        array = new char[width][length];

        for (int i = 0; i < width; i++) {
            String string = br.readLine();

            for (int j = 0; j < length; j++) {
                array[i][j] = string.charAt(j);
            }
        }

        int max = 0;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (array[i][j] == 'L') {
                    int tempMax = bfs(new boolean[width][length], i, j);

                    if (tempMax > max) {
                        max = tempMax;
                    }
                }
            }
        }

        bw.write(Integer.toString(max));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int bfs(boolean[][] visited, int y, int x) {
        int max = 0;

        visited[y][x] = true;
        queue.offer(new Coordinate(y, x, 0));

        while (!queue.isEmpty()) {
            Coordinate currentCoordinate = queue.poll();

            if (currentCoordinate.weight > max) {
                max = currentCoordinate.weight;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = currentCoordinate.y + dy[i];
                int nextX = currentCoordinate.x + dx[i];

                if (nextY < 0 || nextY >= width || nextX < 0 || nextX >= length) {
                    continue;
                }

                if (array[nextY][nextX] == 'W') {
                    continue;
                }

                if (visited[nextY][nextX]) {
                    continue;
                }

                visited[nextY][nextX] = true;

                queue.offer(new Coordinate(nextY, nextX, currentCoordinate.weight + 1));
            }
        }

        return max;
    }

    private static class Coordinate {

        final int y;
        final int x;
        final int weight;

        Coordinate(int y, int x, int weight) {
            this.y = y;
            this.x = x;
            this.weight = weight;
        }
    }
}
