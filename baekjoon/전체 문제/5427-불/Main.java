import java.io.*;
import java.util.*;

public class Main {

    private static final List<Coordinate> buffer = new ArrayList<>();
    private static final Queue<Coordinate> queue = new ArrayDeque<>();
    private static final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static int w;
    private static int h;

    private static boolean[][] array;
    private static char[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            buffer.clear();
            queue.clear();

            Coordinate sanggeun = null;

            array = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                String string = br.readLine();

                for (int j = 0; j < w; j++) {
                    char c = string.charAt(j);

                    if (c == '@') {
                        sanggeun = new Coordinate(i, j, '@', 0);
                    } else if (c == '*') {
                        buffer.add(new Coordinate(i, j, '*', -1));
                    }

                    if (c != '#') {
                        array[i][j] = true;
                    }
                }
            }

            buffer.add(sanggeun);

            visited = new char[h][w];

            sb.append(bfs()).append('\n');
        }

        bw.write(sb.toString().trim());
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

                if (currentCoordinate.type == '@') {
                    if (nextY < 0 || nextY >= h || nextX < 0 || nextX >= w) {
                        return Integer.toString(currentCoordinate.weight + 1);
                    }

                    if (!array[nextY][nextX]) {
                        continue;
                    }

                    if (visited[nextY][nextX] != '\0') {
                        continue;
                    }

                    visited[nextY][nextX] = '@';

                    queue.offer(new Coordinate(nextY, nextX, '@', currentCoordinate.weight + 1));
                } else { // *
                    if (nextY < 0 || nextY >= h || nextX < 0 || nextX >= w) {
                        continue;
                    }

                    if (!array[nextY][nextX]) {
                        continue;
                    }

                    if (visited[nextY][nextX] != '\0' && visited[nextY][nextX] != '@') {
                        continue;
                    }

                    visited[nextY][nextX] = '*';

                    queue.offer(new Coordinate(nextY, nextX, '*', -1));
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
