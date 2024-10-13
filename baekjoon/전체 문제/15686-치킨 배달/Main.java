import java.io.*;
import java.util.*;

// 시간 초과
public class Main {

    private static final List<Coordinate> chickens = new ArrayList<>();
    private static final Queue<Coordinate> queue = new LinkedList<>();
    private static final int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static int N;

    private static int[][] array;

    private static boolean[] visited;

    private static int minimumChickenDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        array = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int number = Integer.parseInt(st.nextToken());

                if (number == 2) {
                    chickens.add(new Coordinate(i, j));

                    continue;
                }

                array[i][j] = number;
            }
        }

        visited = new boolean[chickens.size()];

        backtracking(M, 0);

        bw.write(Integer.toString(minimumChickenDistance));
        bw.flush();

        br.close();
        bw.close();
    }

    // 치킨집 M개 선택
    private static void backtracking(int depth, int nextNumber) {
        if (depth == 0) {
            // 치킨집 적용
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i]) {
                    continue;
                }

                array[chickens.get(i).y][chickens.get(i).x] = 2;
            }

            int totalChickenDistance = 0;

            loop:
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (array[i][j] != 1) {
                        continue;
                    }

                    totalChickenDistance += bfs(i, j);

                    // 이미 최소를 넘은 경우, 추가로 찾을 필요 없다.
                    if (totalChickenDistance > minimumChickenDistance) {
                        break loop;
                    }
                }
            }

            minimumChickenDistance = Math.min(minimumChickenDistance, totalChickenDistance);

            // 치킨집 초기화
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i]) {
                    continue;
                }

                array[chickens.get(i).y][chickens.get(i).x] = 0;
            }

            return;
        }

        for (int i = nextNumber; i < visited.length; i++) {
            visited[i] = true;
            backtracking(depth - 1, i + 1);
            visited[i] = false;
        }
    }

    // 집에서 가장 가까운 치킨 거리 반환
    private static int bfs(int y, int x) {
        int minimumChickenDistance = Integer.MAX_VALUE;

        int[][] visited = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = -1;
            }
        }

        queue.offer(new Coordinate(y, x));
        visited[y][x] = 0;

        while (!queue.isEmpty()) {
            Coordinate currentCoordinate = queue.poll();

            if (array[currentCoordinate.y][currentCoordinate.x] == 2) {
                minimumChickenDistance = Math.min(minimumChickenDistance, visited[currentCoordinate.y][currentCoordinate.x]);
            }

            for (int i = 0; i < 4; i++) {
                int nextY = currentCoordinate.y + dyx[i][0];
                int nextX = currentCoordinate.x + dyx[i][1];

                if (nextY < 0 || nextY >= N || nextX < 0 || nextX >= N) {
                    continue;
                }

                if (visited[nextY][nextX] != -1) {
                    continue;
                }

                queue.offer(new Coordinate(nextY, nextX));
                visited[nextY][nextX] = visited[currentCoordinate.y][currentCoordinate.x] + 1;
            }
        }

        return minimumChickenDistance;
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
