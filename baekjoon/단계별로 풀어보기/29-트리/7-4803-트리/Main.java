import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int caseCountNumber = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int vertexNumber = Integer.parseInt(st.nextToken());
            int edgeNumber = Integer.parseInt(st.nextToken());

            if (vertexNumber == 0 && edgeNumber == 0) {
                break;
            }

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            boolean[] isVisited = new boolean[vertexNumber + 1];

            for (int i = 0; i <= vertexNumber; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < edgeNumber; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            int treeCountNumber = 0;
            for (int i = 1; i <= vertexNumber; i++) {
                if (!isVisited[i] && dfs(graph, isVisited, i, 0)) {
                    treeCountNumber++;
                }
            }

            sb.append("Case ").append(caseCountNumber++).append(": ");
            if (treeCountNumber == 0) {
                sb.append("No trees.\n");
            } else if (treeCountNumber == 1) {
                sb.append("There is one tree.\n");
            } else {
                sb.append("A forest of ").append(treeCountNumber).append(" trees.\n");
            }
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    private static boolean dfs(List<ArrayList<Integer>> graph, boolean[] isVisited,
        int current, int before) {
        isVisited[current] = true;

        for (Integer vertex : graph.get(current)) {
            if (vertex != before) {
                if (isVisited[vertex] || !dfs(graph, isVisited, vertex, current)) {
                    return false;
                }
            }
        }
        return true;
    }
}
