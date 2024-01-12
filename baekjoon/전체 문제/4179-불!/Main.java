import java.io.*;
import java.util.*;

public class Main {

    private static final Queue<Coordinate> queue = new ArrayDeque<>();
    private static final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static int R;
    private static int C;
    private static List<Coordinate> buffer;
    private static boolean[][] array;
    private static char[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        buffer = new ArrayList<>();
        Coordinate jihun = null;

        array = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String string = br.readLine();

            for (int j = 0; j < C; j++) {
                char c = string.charAt(j);

                if (c == 'J') {
                    jihun = new Coordinate(i, j, 'J', 0);
                } else if (c == 'F') {
                    buffer.add(new Coordinate(i, j, 'F', -1));
                }

                if (c != '#') {
                    array[i][j] = true;
                }
            }
        }

        buffer.add(jihun);

        visited = new char[R][C];

        bw.write(bfs());
        bw.flush();

        br.close();
        bw.close();
    }

    private static String bfs() {
        for (Coordinate coordinate : buffer) {
            visited[coordinate.y][coordinate.x] = coordinate.type;

            queue.offer(coordinate);
        }

        while (!queue.isEmpty()) {
            Coordinate currentCoordinate = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = currentCoordinate.y + dyx[i][0];
                int nextX = currentCoordinate.x + dyx[i][1];

                if (currentCoordinate.type == 'J') {
                    if (nextY < 0 || nextY >= R || nextX < 0 || nextX >= C) {
                        return Integer.toString(currentCoordinate.weight + 1);
                    }

                    if (!array[nextY][nextX]) {
                        continue;
                    }

                    if (visited[nextY][nextX] != '\0') {
                        continue;
                    }

                    visited[nextY][nextX] = 'J';

                    queue.offer(new Coordinate(nextY, nextX, 'J', currentCoordinate.weight + 1));
                } else { // F
                    if (nextY < 0 || nextY >= R || nextX < 0 || nextX >= C) {
                        continue;
                    }

                    if (!array[nextY][nextX]) {
                        continue;
                    }

                    if (visited[nextY][nextX] != '\0' && visited[nextY][nextX] != 'J') {
                        continue;
                    }

                    visited[nextY][nextX] = 'F';

                    queue.offer(new Coordinate(nextY, nextX, 'F', -1));
                }
            }
        }

        return "IMPOSSIBLE";
    }

    private static class Coordinate {

        final int y;
        final int x;
        final char type;
        final int weight;

        Coordinate(int y, int x, char type, int weight) {
            this.y = y;
            this.x = x;
            this.type = type;
            this.weight = weight;
        }
    }
}
