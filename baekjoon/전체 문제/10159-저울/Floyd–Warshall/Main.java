import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static boolean[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graph = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            graph[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
        }

        floydWarshall();

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            int count = 0;

            for (int j = 1; j <= N; j++) {
                if (!(graph[i][j] || graph[j][i])) { // 방문할 수 없는 경우 -> j vertex 크기 비교가 불가능한 경우
                    count++;
                }
            }

            // 본인 제외
            sb.append(count - 1).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void floydWarshall() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (graph[i][k] && graph[k][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }
    }
}
