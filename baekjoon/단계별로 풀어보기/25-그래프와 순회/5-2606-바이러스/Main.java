import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int vertexCount = Integer.parseInt(br.readLine());
        int edgeCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < vertexCount + 1; i++) {
            graph.add(new ArrayList<>());
        }

        isVisited = new boolean[vertexCount + 1];

        for (int i = 0; i < edgeCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i < graph.size(); i++) {
            graph.get(i).sort(Comparator.naturalOrder());
        }

        bw.write(Integer.toString(bfs(1)));

        bw.flush();
        bw.close();
    }

    private static int bfs(int startVertex) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(startVertex);
        isVisited[startVertex] = true;

        int answer = 0;
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            for (int nextVertex : graph.get(currentVertex)) {
                if (!isVisited[nextVertex]) {
                    isVisited[nextVertex] = true;
                    queue.offer(nextVertex);
                    answer++;
                }
            }
        }

        return answer;
    }
}
