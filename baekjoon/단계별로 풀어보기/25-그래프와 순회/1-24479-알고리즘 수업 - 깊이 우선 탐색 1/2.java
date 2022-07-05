import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static int count = 1;
    private static final ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static int[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertexCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(st.nextToken());

        for (int i = 0; i < vertexCount + 1; i++) {
            graph.add(new ArrayList<>());
        }

        isVisited = new int[vertexCount + 1];

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i < graph.size(); i++) {
            graph.get(i).sort(Integer::compareTo);
        }

        dfs(startVertex);

        for (int i = 1; i < graph.size(); i++) {
            sb.append(isVisited[i]).append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    private static void dfs(int currentVertex) {
        isVisited[currentVertex] = count++;
        for (int nextVertex : graph.get(currentVertex)) {
            if (isVisited[nextVertex] <= 0) {
                dfs(nextVertex);
            }
        }
    }
}
