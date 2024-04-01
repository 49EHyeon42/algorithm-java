import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Main {

    private static final Stack<Integer> stack = new Stack<>();
    private static final Set<Integer> set = new HashSet<>();

    private static int N;

    private static int[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        graph = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            dfs(i);
        }

        StringBuilder sb = new StringBuilder();

        sb.append(set.size());

        set.stream().sorted().forEach(i -> sb.append('\n').append(i));

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void dfs(int startVertex) {
        int[] visited = new int[N + 1];

        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();

            int nextVertex = graph[currentVertex];

            if (visited[nextVertex] != 0) {
                int beforeVertex = currentVertex;

                while (beforeVertex != nextVertex) {
                    set.add(beforeVertex);

                    beforeVertex = visited[beforeVertex];
                }

                set.add(beforeVertex);

                return;
            }

            visited[nextVertex] = currentVertex;

            stack.push(nextVertex);
        }
    }
}
