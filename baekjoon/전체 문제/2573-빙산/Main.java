import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final Queue<Coordinate> queue = new ArrayDeque<>();
    private static final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static int N;
    private static int M;

    private static int[][] array;
    private static boolean[][] visited;
    private static int[][] difference; // buffer

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[N][M];
        visited = new boolean[N][M];
        difference = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;

        int check = 1; // bfs 횟수 확인

        while (check > 0) {
            check = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (array[i][j] == 0 || visited[i][j]) {
                        continue;
                    }

                    bfs(i, j);

                    check++;
                }
            }

            // init array, visited, difference
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    visited[i][j] = false;

                    if (difference[i][j] == 0) {
                        continue;
                    }

                    array[i][j] = Math.max(0, array[i][j] - difference[i][j]);

                    difference[i][j] = 0;
                }
            }

            if (check == 0) {
                count = 0;
                break;
            } else if (check == 1) {
                count++;
            } else { // check > 1
                break;
            }
        }

        bw.write(Integer.toString(count));
        bw.flush();

        br.close();
        bw.close();
    }

    private static void bfs(int startY, int startX) {
        visited[startY][startX] = true;

        queue.offer(new Coordinate(startY, startX));

        while (!queue.isEmpty()) {
            Coordinate currentCoordinate = queue.poll();

            int count = 0;

            for (int i = 0; i < 4; i++) {
                int nextY = currentCoordinate.y + dyx[i][0];
                int nextX = currentCoordinate.x + dyx[i][1];

                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= M) {
                    continue;
                }

                if (array[nextY][nextX] == 0) {
                    count++;
                    continue;
                }

                if (visited[nextY][nextX]) {
                    continue;
                }

                visited[nextY][nextX] = true;

                queue.offer(new Coordinate(nextY, nextX));
            }

            difference[currentCoordinate.y][currentCoordinate.x] = count;
        }
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
