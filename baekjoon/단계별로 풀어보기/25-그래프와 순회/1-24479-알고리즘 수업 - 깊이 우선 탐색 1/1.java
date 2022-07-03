import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 메모리 초과
public class Main {

    private static final StringBuilder sb = new StringBuilder();

    private static boolean[][] graph;
    private static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertexCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(st.nextToken());

        graph = new boolean[vertexCount + 1][vertexCount + 1];
        isVisited = new boolean[vertexCount + 1];

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u][v] = true;
            graph[v][u] = true;
        }

        dfs(startVertex);

        bw.write(sb.append(0).toString());

        bw.flush();
        bw.close();
    }

    private static void dfs(int currentVertex) {
        isVisited[currentVertex] = true;
        sb.append(currentVertex).append('\n');
        for (int i = 1; i <= graph.length - 1; i++) {
            if (graph[currentVertex][i] && !isVisited[i]) {
                dfs(i);
            }
        }
    }
}
