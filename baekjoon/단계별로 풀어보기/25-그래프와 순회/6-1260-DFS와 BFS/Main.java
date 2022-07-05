import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static final StringBuilder sb = new StringBuilder();

    private static final ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertexCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(st.nextToken());

        for (int i = 0; i < vertexCount + 1; i++) {
            graph.add(new ArrayList<>());
        }

        isVisited = new boolean[vertexCount + 1];

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // dfs
        for (int i = 1; i < graph.size(); i++) {
            graph.get(i).sort(Comparator.reverseOrder());
        }

        dfs(startVertex);

        // init
        Arrays.fill(isVisited, false);

        sb.append('\n');

        // bfs
        for (int i = 1; i < graph.size(); i++) {
            graph.get(i).sort(Comparator.naturalOrder());
        }

        bfs(startVertex);

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    private static void dfs(int startVertex) {
        Stack<Integer> stack = new Stack<>();

        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();

            if (!isVisited[currentVertex]) {
                isVisited[currentVertex] = true;

                sb.append(currentVertex).append(' ');

                for (int nextVertex : graph.get(currentVertex)) {
                    if (!isVisited[nextVertex]) {
                        stack.push(nextVertex);
                    }
                }
            }
        }
    }

    private static void bfs(int startVertex) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(startVertex);
        isVisited[startVertex] = true;

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            sb.append(currentVertex).append(' ');

            for (int nextVertex : graph.get(currentVertex)) {
                if (!isVisited[nextVertex]) {
                    isVisited[nextVertex] = true;
                    queue.offer(nextVertex);
                }
            }
        }
    }
}
