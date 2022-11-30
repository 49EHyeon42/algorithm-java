import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private static final int[] dy = {1, -1, 0, 0};
    private static final int[] dx = {0, 0, 1, -1};

    private int maxLength;
    private int maxWidth;

    private char[][] grid;
    private boolean[][] visit;

    public int numIslands(char[][] grid) {
        maxLength = grid.length;
        maxWidth = grid[0].length;

        this.grid = grid;
        visit = new boolean[maxLength][maxWidth];

        int count = 0;
        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < maxWidth; j++) {
                if (grid[i][j] == '1' && !visit[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{y, x});
        visit[y][x] = true;

        while (!queue.isEmpty()) {
            int[] currentCoordinate = queue.poll();

            for (int i = 0; i < 4; i++) {
                int currentY = currentCoordinate[0] + dy[i];
                int currentX = currentCoordinate[1] + dx[i];

                if (isPossible(currentY, currentX) && grid[currentY][currentX] == '1'
                    && !visit[currentY][currentX]) {
                    queue.offer(new int[]{currentY, currentX});
                    visit[currentY][currentX] = true;
                }
            }
        }
    }

    private boolean isPossible(int y, int x) {
        return y >= 0 && x >= 0 && y < maxLength && x < maxWidth;
    }
}
