import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final Queue<Coordinate> queue = new LinkedList<>();
    private static final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static int R;
    private static int C;

    private static char[][] graph;
    private static boolean[][] visit;

    private static int totalSheep = 0;
    private static int totalWolf = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new char[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            graph[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[i][j] != '#' && !visit[i][j]) {
                    bfs(new Coordinate(i, j));
                }
            }
        }

        bw.write(totalSheep + " " + totalWolf);
        bw.flush();

        br.close();
        bw.close();
    }

    private static void bfs(Coordinate startCoordinate) {
        int sheepCount = 0;
        int wolfCount = 0;

        queue.offer(startCoordinate);
        visit[startCoordinate.y][startCoordinate.x] = true;

        while (!queue.isEmpty()) {
            Coordinate currentCoordinate = queue.poll();

            if (graph[currentCoordinate.y][currentCoordinate.x] == 'k') {
                sheepCount++;
            } else if (graph[currentCoordinate.y][currentCoordinate.x] == 'v') {
                wolfCount++;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = currentCoordinate.y + dyx[i][0];
                int nextX = currentCoordinate.x + dyx[i][1];

                if (nextY < 0 || nextY >= R || nextX < 0 || nextX >= C) {
                    continue;
                }

                if (graph[nextY][nextX] == '#') {
                    continue;
                }

                if (visit[nextY][nextX]) {
                    continue;
                }

                queue.offer(new Coordinate(nextY, nextX));
                visit[nextY][nextX] = true;
            }
        }

        if (sheepCount > wolfCount) {
            totalSheep += sheepCount;
        } else {
            totalWolf += wolfCount;
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
