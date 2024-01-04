import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final Queue<Vertex> queue = new ArrayDeque<>();
    private static final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static int H;
    private static int W;
    private static boolean[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        array = new boolean[H][W];
        Coordinate[] cheese = new Coordinate[n + 1];

        for (int i = 0; i < H; i++) {
            String string = br.readLine();

            for (int j = 0; j < W; j++) {
                char c = string.charAt(j);

                if (c == 'S') {
                    cheese[0] = new Coordinate(i, j);
                } else if (c == 'X') {
                    array[i][j] = true;
                } else if (c >= '1' && c <= '9') {
                    cheese[c - '0'] = new Coordinate(i, j);
                }
            }
        }

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += bfs(cheese[i], cheese[i + 1]);
        }

        bw.write(Integer.toString(sum));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int bfs(Coordinate startCoordinate, Coordinate endCoordinate) {
        boolean[][] visited = new boolean[H][W];

        visited[startCoordinate.y][startCoordinate.x] = true;

        queue.clear();

        queue.offer(new Vertex(startCoordinate.y, startCoordinate.x, 0));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            if (currentVertex.y == endCoordinate.y && currentVertex.x == endCoordinate.x) {
                return currentVertex.weight;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = currentVertex.y + dyx[i][0];
                int nextX = currentVertex.x + dyx[i][1];

                if (nextY < 0 || nextY >= H || nextX < 0 || nextX >= W) {
                    continue;
                }

                if (array[nextY][nextX]) {
                    continue;
                }

                if (visited[nextY][nextX]) {
                    continue;
                }

                visited[nextY][nextX] = true;

                queue.offer(new Vertex(nextY, nextX, currentVertex.weight + 1));
            }
        }

        // exception
        return -1;
    }

    private static class Coordinate {

        final int y;
        final int x;

        Coordinate(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static class Vertex {

        final int y;
        final int x;
        final int weight;

        Vertex(int y, int x, int weight) {
            this.y = y;
            this.x = x;
            this.weight = weight;
        }
    }
}
