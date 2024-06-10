import java.io.*;
import java.util.StringTokenizer;

public class Main {

    // 우 -> 하 -> 좌 -> 상
    private static int[][] dyx = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[M][N];
        visited[0][0] = true;

        int count = 0;

        int way = 0;

        int currentY = 0;
        int currentX = 0;

        while (true) {
            int nextY = currentY + dyx[way][0];
            int nextX = currentX + dyx[way][1];

            if (nextY >= 0 && nextX >= 0 && nextY < M && nextX < N && !visited[nextY][nextX]) {
                visited[nextY][nextX] = true;

                currentY = nextY;
                currentX = nextX;

                continue;
            }

            way = (way + 1) % 4;

            nextY = currentY + dyx[way][0];
            nextX = currentX + dyx[way][1];

            // 방향을 변경했음에도 갈 수 없는 경우
            if (nextY < 0 || nextX < 0 || nextY >= M || nextX >= N || visited[nextY][nextX]) {
                break;
            }

            // 방향 변경 후 갈 수 있는 경우
            count++;
        }


        bw.write(Integer.toString(count));
        bw.flush();

        br.close();
        bw.close();
    }
}
