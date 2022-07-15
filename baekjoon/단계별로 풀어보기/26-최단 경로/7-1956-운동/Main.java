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

        StringTokenizer st = new StringTokenizer(br.readLine());
        vertexNumber = Integer.parseInt(st.nextToken());
        int edgeNumber = Integer.parseInt(st.nextToken());

        graph = new int[vertexNumber + 1][vertexNumber + 1];
        for (int i = 1; i <= vertexNumber; i++) {
            for (int j = 1; j <= vertexNumber; j++) {
                graph[i][j] = (i == j) ? 0 : INF;
            }
        }

        for (int i = 0; i < edgeNumber; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[vertex1][vertex2] = Math.min(graph[vertex1][vertex2], weight);
        }

        floydWarshall();

        int answer = INF;
        for (int i = 1; i <= vertexNumber; i++) {
            for (int j = 1; j <= vertexNumber; j++) {
                if (i != j && graph[i][j] != INF && graph[j][i] != INF) {
                    answer = Math.min(answer, graph[i][j] + graph[j][i]);
                }
            }
        }

        answer = (answer == INF) ? -1 : answer;

        bw.write(Integer.toString(answer));

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
