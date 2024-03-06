import java.io.*;
import java.util.*;

public class Main {

    private static final Map<Integer, List<Vertex>> graph = new HashMap<>();
    private static final Queue<Integer> queue = new LinkedList<>();

    private static int N;

    private static int startVertex;
    private static int endVertex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        int minimumWeight = 1;
        int maximumWeight = -1;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph.get(A).add(new Vertex(B, C));
            graph.get(B).add(new Vertex(A, C));

            maximumWeight = Math.max(maximumWeight, C);
        }

        st = new StringTokenizer(br.readLine());
        startVertex = Integer.parseInt(st.nextToken());
        endVertex = Integer.parseInt(st.nextToken());

        while (minimumWeight < maximumWeight) {
            int targetWeight = (minimumWeight + maximumWeight) / 2;

            if (bfs(targetWeight)) {
                minimumWeight = targetWeight + 1;
            } else {
                maximumWeight = targetWeight;
            }
        }

        bw.write(Integer.toString(maximumWeight));
        bw.flush();

        br.close();
        bw.close();
    }

    private static boolean bfs(int maxWeight) {
        boolean[] visited = new boolean[N + 1];

        queue.clear();

        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            if (currentVertex == endVertex) {
                return true;
            }

            for (Vertex nextVertex : graph.get(currentVertex)) {
                if (visited[nextVertex.number]) {
                    continue;
                }

                if (nextVertex.weight <= maxWeight) {
                    continue;
                }

                visited[nextVertex.number] = true;

                queue.offer(nextVertex.number);
            }
        }

        return false;
    }

    private static class Vertex {

        int number;
        int weight;

        Vertex(int number, int weight) {
            this.number = number;
            this.weight = weight;
        }
    }
}
