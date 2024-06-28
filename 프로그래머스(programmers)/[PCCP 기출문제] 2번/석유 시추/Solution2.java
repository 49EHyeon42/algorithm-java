import java.util.*;

// 정확성 100, 효율성 100
class Solution {

    private final Queue<Coordinate> queue = new LinkedList<>();
    private final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int n;
    private int m;

    private int[][] visited;

    Map<Integer, Integer> oils = new HashMap<>();

    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;

        visited = new int[n][m];

        findOilsWithBfs(land);

        int maxOil = Integer.MIN_VALUE;

        Set<Integer> temp = new HashSet<>();

        for (int j = 0; j < m; j++) {
            int oil = 0;

            temp.clear();

            for (int i = 0; i < n; i++) {
                if (visited[i][j] == 0 || temp.contains(visited[i][j])) {
                    continue;
                }

                oil += oils.get(visited[i][j]);

                temp.add(visited[i][j]);
            }

            maxOil = Math.max(maxOil, oil);
        }

        return maxOil;
    }

    private void findOilsWithBfs(int[][] land) {
        int index = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 0 || visited[i][j] != 0) {
                    continue;
                }

                oils.put(index, bfs(land, index, i, j));

                index++;
            }
        }
    }

    private int bfs(int[][] land, int index, int startY, int startX) {
        queue.clear();

        queue.offer(new Coordinate(startY, startX));
        visited[startY][startX] = index;

        int oil = 1;

        while (!queue.isEmpty()) {
            Coordinate currentCoordinate = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = currentCoordinate.y + dyx[i][0];
                int nextX = currentCoordinate.x + dyx[i][1];

                if (nextY < 0 || nextY >= n || nextX < 0 || nextX >= m) {
                    continue;
                }

                if (land[nextY][nextX] != 1 || visited[nextY][nextX] != 0) {
                    continue;
                }

                queue.offer(new Coordinate(nextY, nextX));
                visited[nextY][nextX] = index;

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
