import java.io.*;
import java.util.*;

public class Main1 {

    private static final List<Coordinate> homes = new ArrayList<>();
    private static final List<Coordinate> chickens = new ArrayList<>();

    private static boolean[] visited;

    private static int minimumTotalChickenDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int number = Integer.parseInt(st.nextToken());

                if (number == 1) {
                    homes.add(new Coordinate(j, i));
                } else if (number == 2) {
                    chickens.add(new Coordinate(j, i));
                }
            }
        }

        visited = new boolean[chickens.size()];

        backtracking(M, 0);

        bw.write(Integer.toString(minimumTotalChickenDistance));
        bw.flush();

        br.close();
        bw.close();
    }

    private static void backtracking(int depth, int nextNumber) {
        if (depth == 0) {
            int totalChickenDistance = 0;

            for (Coordinate home : homes) {
                int minimumChickenDistance = Integer.MAX_VALUE;

                for (int i = 0; i < visited.length; i++) {
                    if (!visited[i]) {
                        continue;
                    }

                    // 치킨 거리 계산
                    int tempChickenDistance = Math.abs(home.y - chickens.get(i).y) + Math.abs(home.x - chickens.get(i).x);

                    // 계산한 치킨 거리 중 최소 값만 저장
                    minimumChickenDistance = Math.min(minimumChickenDistance, tempChickenDistance);
                }

                // 최소 치킨 거리 합
                totalChickenDistance += minimumChickenDistance;
            }

            // 최소 치킨 거리 합 중 가장 작은 최소 치킨 거리 합 저장
            minimumTotalChickenDistance = Math.min(minimumTotalChickenDistance, totalChickenDistance);

            return;
        }

        for (int i = nextNumber; i < visited.length; i++) {
            visited[i] = true;
            backtracking(depth - 1, i + 1);
            visited[i] = false;
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
