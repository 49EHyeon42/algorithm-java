import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Floyd–Warshall algorithm
public class Main {

    private static final int INF = Integer.MAX_VALUE;

    private static int vertexNumber;

    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        vertexNumber = Integer.parseInt(br.readLine());
        int edgeNumber = Integer.parseInt(br.readLine());

        graph = new int[vertexNumber + 1][vertexNumber + 1];
        for (int i = 1; i <= vertexNumber; i++) {
            for (int j = 1; j <= vertexNumber; j++) {
                graph[i][j] = (i == j) ? 0 : INF;
            }
        }

        for (int i = 0; i < edgeNumber; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startCity = Integer.parseInt(st.nextToken());
            int endCity = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[startCity][endCity] = Math.min(graph[startCity][endCity], cost);
        }

        floydWarshall();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= vertexNumber; i++) {
            for (int j = 1; j <= vertexNumber; j++) {
                if (graph[i][j] == INF) {
                    sb.append("0 ");
                } else {
                    sb.append(graph[i][j]).append(' ');
                }
            }
            sb.append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    private static void floydWarshall() {
        for (int k = 1; k <= vertexNumber; k++) {
            for (int i = 1; i <= vertexNumber; i++) {
                for (int j = 1; j <= vertexNumber; j++) {
                    if (graph[i][k] != INF && graph[k][j] != INF) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
        }
    }
}
