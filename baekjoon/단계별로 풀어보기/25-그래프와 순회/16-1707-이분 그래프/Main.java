import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static ArrayList<ArrayList<Integer>> graph;
    // isVisited ? RED or BLUE : null
    private static Color[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int vertexNumber = Integer.parseInt(st.nextToken());
            int edgeNumber = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            isVisited = new Color[vertexNumber + 1];

            for (int j = 0; j <= vertexNumber; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < edgeNumber; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            for (int currentVertex = 1; currentVertex <= vertexNumber; currentVertex++) {
                if (isVisited[currentVertex] == null) {
                    bfs(currentVertex);
                }
            }

            sb.append(isBipartiteGraph(vertexNumber) ? "YES" : "NO").append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    private static boolean isBipartiteGraph(int vertexNumber) {
        for (int currentVertex = 1; currentVertex <= vertexNumber; currentVertex++) {
            for (int nextVertex : graph.get(currentVertex)) {
                if (isVisited[currentVertex].equals(isVisited[nextVertex])) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void bfs(int startVertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startVertex);
        isVisited[startVertex] = Color.RED;

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            for (int nextVertex : graph.get(currentVertex)) {
                if (isVisited[nextVertex] == null) {
                    queue.offer(nextVertex);
                    isVisited[nextVertex] =
                        (isVisited[currentVertex].equals(Color.RED)) ? Color.BLUE : Color.RED;
                }
            }
        }
    }

    private enum Color {
        RED, BLUE
    }
}
