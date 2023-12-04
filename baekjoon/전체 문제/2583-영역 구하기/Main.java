import java.io.*;
import java.util.*;

public class Main {

    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};
    private static final Queue<int[]> queue = new ArrayDeque<>();

    private static int M;
    private static int N;
    private static boolean[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        array = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;

            if (x1 > x2) {
                int temp = x1;
                x1 = x2;
                x2 = temp;
            }

            if (y1 > y2) {
                int temp = y1;
                y1 = y2;
                y2 = temp;
            }

            for (int y = y1; y <= y2; y++) {
                for (int x = x1; x <= x2; x++) {
                    array[y][x] = true;
                }
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int y = 0; y < M; y++) {
            for (int x = 0; x < N; x++) {
                if (!array[y][x]) {
                    list.add(bfs(y, x));
                }
            }
        }

        list.sort(Integer::compareTo);

        sb.append(list.size()).append('\n');

        for (int i : list) {
            sb.append(i).append(' ');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static int bfs(int startY, int startX) {
        int count = 1;

        array[startY][startX] = true;

        queue.offer(new int[]{startY, startX});

        while (!queue.isEmpty()) {
            int[] currentCoordinate = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = currentCoordinate[0] + dy[i];
                int nextX = currentCoordinate[1] + dx[i];

                if (nextY < 0 || nextY >= M || nextX < 0 || nextX >= N) {
                    continue;
                }

                if (array[nextY][nextX]) {
                    continue;
                }

                array[nextY][nextX] = true;

                queue.offer(new int[]{nextY, nextX});

                count++;
            }
        }

        return count;
    }
}
