import java.util.*;

public class Solution {

    private static final Queue<Coordinate> queue = new LinkedList<>();
    private static final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final Set<String> set = new HashSet<>();

    private static char[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            sb.append('#').append(i).append(' ');

            graph = new char[4][4];

            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    graph[j][k] = sc.next().charAt(0);
                }
            }

            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    bfs(j, k);
                }
            }

            sb.append(set.size()).append('\n');

            set.clear();
        }

        System.out.print(sb.toString().trim());
    }

    private static void bfs(int startY, int startX) {
        queue.offer(new Coordinate(startY, startX, graph[startY][startX] + ""));

        while (!queue.isEmpty()) {
            Coordinate currentCoordinate = queue.poll();

            if (currentCoordinate.string.length() == 7) {
                set.add(currentCoordinate.string);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = currentCoordinate.y + dyx[i][0];
                int nextX = currentCoordinate.x + dyx[i][1];

                if (nextY < 0 || nextY >= graph.length || nextX < 0 || nextX >= graph[0].length) {
                    continue;
                }

                queue.offer(new Coordinate(nextY, nextX, currentCoordinate.string + graph[nextY][nextX]));
            }
        }
    }

    private static class Coordinate {

        final int y;
        final int x;
        final String string;

        Coordinate(int y, int x, String string) {
            this.y = y;
            this.x = x;
            this.string = string;
        }
    }
}
