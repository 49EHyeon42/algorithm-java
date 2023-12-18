import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int S;

    private static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());

            graph.get(vertex1).add(vertex2);
            graph.get(vertex2).add(vertex1);
        }

        bw.write(Integer.toString(N - bfs(P)));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int bfs(int startVertex) {
        // find min
        int[] array = new int[S];

        boolean[] visited = new boolean[N + 1];

        Queue<Vertex> queue = new ArrayDeque<>();

        queue.offer(new Vertex(startVertex, 0));

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            if (currentVertex.number <= S) {
                array[currentVertex.number - 1] = currentVertex.count;
            }

            for (int nextVertex : graph.get(currentVertex.number)) {
                if (visited[nextVertex]) {
                    continue;
                }

                visited[nextVertex] = true;

                queue.offer(new Vertex(nextVertex, currentVertex.count + 1));
            }
        }

        Arrays.sort(array);

        // P 기준 최단 2개 + 자기자신
        return array[0] + array[1] + 1;
    }

    private static class Vertex {

        final int number;
        final int count;

        Vertex(int number, int count) {
            this.number = number;
            this.count = count;
        }
    }
}
