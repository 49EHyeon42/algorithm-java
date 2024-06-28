import java.util.*;

// 정확성 100, 효율성 0
class Solution {

    private final Queue<Coordinate> queue = new LinkedList<>();
    private final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int[][] graph;

    private int n;
    private int m;

    private boolean[][] visited;

    public int solution(int[][] land) {
        graph = land;

        n = land.length;
        m = land[0].length;

        int maxOil = Integer.MIN_VALUE;

        for (int j = 0; j < m; j++) {
            visited = new boolean[n][m];

            int oil = 0;

            for (int i = 0; i < n; i++) {
                if (land[i][j] == 0 || visited[i][j]) {
                    continue;
                }

                oil += bfs(i, j);
            }

            maxOil = Math.max(maxOil, oil);
        }

        return maxOil;
    }

    private int bfs(int startY, int startX) {
        queue.clear();

        queue.offer(new Coordinate(startY, startX));
        visited[startY][startX] = true;

        int oil = 1;

        while (!queue.isEmpty()) {
            Coordinate currentCoordinate = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = currentCoordinate.y + dyx[i][0];
                int nextX = currentCoordinate.x + dyx[i][1];

                if (nextY < 0 || nextY >= n || nextX < 0 || nextX >= m) {
                    continue;
                }

                if (graph[nextY][nextX] != 1 || visited[nextY][nextX]) {
                    continue;
                }

                queue.offer(new Coordinate(nextY, nextX));
                visited[nextY][nextX] = true;

                oil++;
            }
        }

        return oil;
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
