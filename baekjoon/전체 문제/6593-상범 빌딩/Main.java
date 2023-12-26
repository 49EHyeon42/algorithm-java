import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[][] dzyx = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};
    private static final Queue<Coordinate> queue = new ArrayDeque<>();

    private static int L;
    private static int R;
    private static int C;

    private static boolean[][][] array;
    private static int[][][] visited;

    private static Coordinate startCoordinate;
    private static Coordinate endCoordinate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            array = new boolean[L][R][C];
            visited = new int[L][R][C];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String string = br.readLine();

                    for (int k = 0; k < C; k++) {
                        if (string.charAt(k) == 'S') {
                            startCoordinate = new Coordinate(i, j, k);
                            array[i][j][k] = true;
                        } else if (string.charAt(k) == 'E') {
                            endCoordinate = new Coordinate(i, j, k);
                            array[i][j][k] = true;
                        } else if (string.charAt(k) == '.') {
                            array[i][j][k] = true;
                        }
                    }
                }

                // 1줄 무시
                br.readLine();
            }

            sb.append(bfs()).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static String bfs() {
        queue.clear();

        visited[startCoordinate.z][startCoordinate.y][startCoordinate.x] = 1;

        queue.offer(startCoordinate);

        while (!queue.isEmpty()) {
            Coordinate currentCoordinate = queue.poll();

            if (currentCoordinate.z == endCoordinate.z && currentCoordinate.y == endCoordinate.y && currentCoordinate.x == endCoordinate.x) {
                return "Escaped in " + (visited[currentCoordinate.z][currentCoordinate.y][currentCoordinate.x] - 1) + " minute(s).";
            }

            for (int i = 0; i < 6; i++) {
                int nextZ = currentCoordinate.z + dzyx[i][0];
                int nextY = currentCoordinate.y + dzyx[i][1];
                int nextX = currentCoordinate.x + dzyx[i][2];

                if (!isPossibleRange(nextZ, nextY, nextX)) {
                    continue;
                }

                if (!array[nextZ][nextY][nextX]) {
                    continue;
                }

                if (visited[nextZ][nextY][nextX] != 0) {
                    continue;
                }

                visited[nextZ][nextY][nextX] = visited[currentCoordinate.z][currentCoordinate.y][currentCoordinate.x] + 1;

                queue.offer(new Coordinate(nextZ, nextY, nextX));
            }
        }

        return "Trapped!";
    }

    private static boolean isPossibleRange(int z, int y, int x) {
        return z >= 0 && z < L && y >= 0 && y < R && x >= 0 && x < C;
    }


    private static class Coordinate {

        final int z;
        final int y;
        final int x;

        Coordinate(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }
}
