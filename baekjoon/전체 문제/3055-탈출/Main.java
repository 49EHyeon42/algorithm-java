import java.io.*;
import java.util.*;

public class Main {

    private static final Queue<Coordinate> queue = new ArrayDeque<>();
    private static final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static int R;
    private static int C;

    private static char[][] array;
    private static char[][] visited;

    private static Coordinate startCoordinate;
    private static Coordinate endCoordinate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        array = new char[R][C];
        // * = 물 방문, S = 고슴도치 방문, X = 물, 고슴도치 방문
        visited = new char[R][C];

        List<Coordinate> buffer = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            String string = br.readLine();

            for (int j = 0; j < C; j++) {
                char c = string.charAt(j);

                if (c == '*') {
                    buffer.add(new Coordinate(i, j, -1)); // don't use count
                } else if (c == 'D') {
                    endCoordinate = new Coordinate(i, j, -1); // don't use count
                } else if (c == 'S') {
                    startCoordinate = new Coordinate(i, j, 0);
                }

                array[i][j] = c;
            }
        }

        buffer.add(startCoordinate);

        bw.write(bfs(buffer));
        bw.flush();

        br.close();
        bw.close();
    }

    private static String bfs(List<Coordinate> buffer) {
        for (Coordinate coordinate : buffer) {
            if (array[coordinate.y][coordinate.x] == '*') {
                visited[coordinate.y][coordinate.x] = '*';
            } else { // S
                visited[coordinate.y][coordinate.x] = 'S';
            }

            queue.offer(coordinate);
        }

        while (!queue.isEmpty()) {
            Coordinate currentCoordinate = queue.poll();

            if (currentCoordinate.y == endCoordinate.y && currentCoordinate.x == endCoordinate.x) {
                return Integer.toString(currentCoordinate.count);
            }

            for (int i = 0; i < 4; i++) {
                int nextY = currentCoordinate.y + dyx[i][0];
                int nextX = currentCoordinate.x + dyx[i][1];

                if (nextY < 0 || nextY >= R || nextX < 0 || nextX >= C) {
                    continue;
                }

                if (array[nextY][nextX] == 'X') {
                    continue;
                }

                if (visited[nextY][nextX] == 'X') {
                    continue;
                }

                if (visited[currentCoordinate.y][currentCoordinate.x] == '*') {
                    if (array[nextY][nextX] == 'D') {
                        continue;
                    }

                    if (visited[nextY][nextX] == '*') {
                        continue;
                    }

                    // 고슴도치 방문 후 홍수가 발생한 경우(물, 고슴도치 이동 모두 차단)
                    visited[nextY][nextX] = visited[nextY][nextX] == 'S' ? 'X' : '*';

                    queue.offer(new Coordinate(nextY, nextX, -1));
                } else {
                    if (visited[nextY][nextX] == '*') {
                        continue;
                    }

                    if (visited[nextY][nextX] == 'S') {
                        continue;
                    }

                    visited[nextY][nextX] = 'S';

                    queue.offer(new Coordinate(nextY, nextX, currentCoordinate.count + 1));
                }
            }
        }

        return "KAKTUS";
    }

    private static class Coordinate {

        final int y;
        final int x;
        final int count;

        Coordinate(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
}
