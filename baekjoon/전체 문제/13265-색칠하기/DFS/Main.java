import java.io.*;
import java.util.*;

public class Main {

    private static final Stack<Integer> stack = new Stack<>();

    private static int n;
    private static List<List<Integer>> graph;
    private static Color[] colors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int vertex1 = Integer.parseInt(st.nextToken());
                int vertex2 = Integer.parseInt(st.nextToken());

                graph.get(vertex1).add(vertex2);
                graph.get(vertex2).add(vertex1);
            }

            colors = new Color[n + 1];
            Arrays.fill(colors, Color.NULL);

            sb.append(dfs()).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static String dfs() {
        stack.clear();

        for (int i = 1; i <= n; i++) {
            if (colors[i] == Color.NULL) {
                // DFS
                stack.push(i);

                colors[i] = Color.A;

                while (!stack.isEmpty()) {
                    int currentVertex = stack.pop();

                    Color nextColor = colors[currentVertex] == Color.A ? Color.B : Color.A;

                    for (int nextVertex : graph.get(currentVertex)) {
                        if (colors[nextVertex] == Color.NULL) {
                            colors[nextVertex] = nextColor;
                            stack.push(nextVertex);
                        } else {
                            if (colors[currentVertex] == colors[nextVertex]) {
                                return "impossible";
                            }
                        }
                    }
                }
            }
        }

        return "possible";
    }

    private enum Color {
        A, B, NULL
    }
}
