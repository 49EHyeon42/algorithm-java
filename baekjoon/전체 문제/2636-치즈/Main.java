import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final Queue<Coordinate> queue = new ArrayDeque<>();
    private static final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static int R;
    private static int C;
    private static boolean[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        array = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < C; j++) {
                if (st.nextToken().equals("1")) {
                    array[i][j] = true;
                }
            }
        }

        int time = 0;
        int cheeseCount;
        int beforeCheeseCount = 0;

        while ((cheeseCount = bfs()) != 0) {
            time++;
            beforeCheeseCount = cheeseCount;
        }

        bw.write(time + "\n" + beforeCheeseCount);
        bw.flush();

        br.close();
        bw.close();
    }

    private static int bfs() {
        int cheeseCount = 0;

        boolean[][] visited = new boolean[R][C];

        visited[0][0] = true;

        queue.offer(new Coordinate(0, 0));

        while (!queue.isEmpty()) {
            Coordinate currentCoordinate = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = currentCoordinate.y + dyx[i][0];
                int nextX = currentCoordinate.x + dyx[i][1];

                if (nextY < 0 || nextY >= R || nextX < 0 || nextX >= C) {
                    continue;
                }

                if (visited[nextY][nextX]) {
                    continue;
                }

                visited[nextY][nextX] = true;

                if (array[nextY][nextX]) {
                    cheeseCount++;

                    array[nextY][nextX] = false;

                    continue;
                }

                queue.offer(new Coordinate(nextY, nextX));
            }
        }

        return cheeseCount;
    }

    private static class Coordinate {

        final int y;
        final int x;

        Coordinate(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
