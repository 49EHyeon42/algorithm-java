import java.util.*;

class Solution {

    private final Queue<Coordinate> queue = new LinkedList<>();
    private final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int n;
    private int m;

    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();

        Coordinate startCoordinate = new Coordinate(-1, -1);
        Coordinate leverCoordinate = new Coordinate(-1, -1);
        Coordinate endCoordinate = new Coordinate(-1, -1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = maps[i].charAt(j);

                if (c == 'S') {
                    startCoordinate.set(i, j);
                } else if (c == 'L') {
                    leverCoordinate.set(i, j);
                } else if (c == 'E') {
                    endCoordinate.set(i, j);
                }
            }
        }

        int startToLever = bfs(maps, startCoordinate, leverCoordinate);

        if (startToLever == -1) {
            return -1;
        }

        int leverToEnd = bfs(maps, leverCoordinate, endCoordinate);

        if (leverToEnd == -1) {
            return -1;
        }

        return startToLever + leverToEnd;
    }

    private int bfs(String[] maps, Coordinate startCoordinate, Coordinate endCoordinate) {
        queue.clear();

        int[][] visited = new int[n][m];

        queue.offer(startCoordinate);

        while (!queue.isEmpty()) {
            Coordinate currentCoordinate = queue.poll();

            if (currentCoordinate.y == endCoordinate.y && currentCoordinate.x == endCoordinate.x) {
                return visited[endCoordinate.y][endCoordinate.x];
            }

            for (int i = 0; i < 4; i++) {
                int nextY = currentCoordinate.y + dyx[i][0];
                int nextX = currentCoordinate.x + dyx[i][1];

                if (nextY < 0 || nextY >= n || nextX < 0 || nextX >= m) {
                    continue;
                }

                if (maps[nextY].charAt(nextX) == 'X' || visited[nextY][nextX] != 0) {
                    continue;
                }

                queue.offer(new Coordinate(nextY, nextX));
                visited[nextY][nextX] = visited[currentCoordinate.y][currentCoordinate.x] + 1;
            }
        }

        return -1;
    }

    private static class Coordinate {

        int y;
        int x;

        Coordinate(int y, int x) {
            this.y = y;
            this.x = x;
        }

        void set(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
