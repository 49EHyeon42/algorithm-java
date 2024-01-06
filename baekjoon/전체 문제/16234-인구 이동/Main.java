import java.io.*;
import java.util.*;

public class Main {

    private static final Queue<Coordinate> queue = new ArrayDeque<>();
    private static final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static final Set<Coordinate> buffer = new HashSet<>();

    private static int N;
    private static int L;
    private static int R;
    private static int[][] array;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        array = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean flag = true;

        int count = 0;

        while (flag) {
            flag = false;

            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) {
                        continue;
                    }

                    if (bfs(i, j)) {
                        flag = true;
                    }
                }
            }

            if (flag) {
                count++;
            }
        }

        bw.write(Integer.toString(count));
        bw.flush();

        br.close();
        bw.close();
    }

    private static boolean bfs(int startY, int startX) {
        int sum = 0;

        buffer.clear();

        visited[startY][startX] = true;

        queue.offer(new Coordinate(startY, startX));

        while (!queue.isEmpty()) {
            Coordinate currentCoordinate = queue.poll();

            sum += array[currentCoordinate.y][currentCoordinate.x];

            buffer.add(currentCoordinate);

            for (int i = 0; i < 4; i++) {
                int nextY = currentCoordinate.y + dyx[i][0];
                int nextX = currentCoordinate.x + dyx[i][1];

                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= N) {
                    continue;
                }

                int difference = Math.abs(array[currentCoordinate.y][currentCoordinate.x] - array[nextY][nextX]);

                if (difference < L || difference > R) {
                    continue;
                }

                if (visited[nextY][nextX]) {
                    continue;
                }

                visited[nextY][nextX] = true;

                queue.offer(new Coordinate(nextY, nextX));
            }
        }

        if (buffer.size() == 1) {
            return false;
        }

        int quotient = sum / buffer.size();

        for (Coordinate coordinate : buffer) {
            array[coordinate.y][coordinate.x] = quotient;
        }

        return true;
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
