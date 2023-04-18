import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int solution(int[][] maps) {
        int maxY = maps.length;
        int maxX = maps[0].length;

        int[][] visited = new int[maxY][maxX];

        return bfs(maps, visited, maxY, maxX);
    }

    private int bfs(int[][] maps, int[][] visited, int maxY, int maxX) {
        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};

        Queue<Vertex> queue = new LinkedList<>();

        queue.offer(new Vertex(0, 0));
        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            if (currentVertex.getY() == maxY - 1 && currentVertex.getX() == maxX - 1) {
                return visited[maxY - 1][maxX - 1];
            }

            for (int i = 0; i < 4; i++) {
                int tempY = currentVertex.getY() + dy[i];
                int tempX = currentVertex.getX() + dx[i];

                if (isPossibleLength(maxY, maxX, tempY, tempX) && maps[tempY][tempX] == 1
                    && visited[tempY][tempX] == 0) {
                    queue.offer(new Vertex(tempY, tempX));
                    visited[tempY][tempX] = visited[currentVertex.getY()][currentVertex.getX()] + 1;
                }
            }
        }

        return -1;
    }

    private boolean isPossibleLength(int maxY, int maxX, int y, int x) {
        return y >= 0 && x >= 0 && y < maxY && x < maxX;
    }

    private static class Vertex {

        private final int y;
        private final int x;

        public Vertex(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }
    }
}
