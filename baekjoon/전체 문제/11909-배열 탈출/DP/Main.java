import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dijkstra = new int[n][n];

        for (int i = 1; i < n; i++) {
            dijkstra[i][0] = (graph[i][0] - graph[i - 1][0] < 0 ? 0 : graph[i][0] - graph[i - 1][0] + 1) + dijkstra[i - 1][0];
            dijkstra[0][i] = (graph[0][i] - graph[0][i - 1] < 0 ? 0 : graph[0][i] - graph[0][i - 1] + 1) + dijkstra[0][i - 1];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dijkstra[i][j] = Math.min(
                        (graph[i][j] - graph[i][j - 1] < 0 ? 0 : graph[i][j] - graph[i][j - 1] + 1) + dijkstra[i][j - 1],
                        (graph[i][j] - graph[i - 1][j] < 0 ? 0 : graph[i][j] - graph[i - 1][j] + 1) + dijkstra[i - 1][j]);
            }
        }

        bw.write(Integer.toString(dijkstra[n - 1][n - 1]));
        bw.flush();

        br.close();
        bw.close();
    }
}
