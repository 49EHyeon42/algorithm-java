import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        List<Edge> edges = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            edges.add(new Edge(0, i, Integer.parseInt(st.nextToken())));
        }

        boolean[] disconnectedEdges = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());

            if (vertex1 > vertex2) {
                int temp = vertex1;
                vertex1 = vertex2;
                vertex2 = temp;
            }

            if (vertex1 == 1 && vertex2 == N) {
                disconnectedEdges[N] = true;
            } else {
                disconnectedEdges[vertex1] = true;
            }
        }

        bw.write(M > 1 ? getResult(N, K, edges, disconnectedEdges) : "YES");

        bw.flush();
        bw.close();
    }

    private static String getResult(int N, long K, List<Edge> edges, boolean[] disconnectedEdges) {
        for (int vertex1 = 1; vertex1 <= N; vertex1++) {
            int vertex2 = vertex1 == N ? 1 : vertex1 + 1;

            if (disconnectedEdges[vertex1]) {
                continue;
            }

            edges.add(new Edge(vertex1, vertex2, 0));
        }

        edges.sort(Comparator.comparingInt(edge -> edge.weight));

        Kruskal kruskal = new Kruskal(N);

        long minimumWeight = 0;

        for (Edge edge : edges) {
            if (!kruskal.isUnion(edge.vertex1, edge.vertex2)) {
                kruskal.merge(edge.vertex1, edge.vertex2);

                minimumWeight += edge.weight;
            }
        }

        return K - minimumWeight >= 0 ? "YES" : "NO";
    }

    private static class Edge {

        private final int vertex1;
        private final int vertex2;
        private final int weight;

        Edge(int vertex1, int vertex2, int weight) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
        }
    }

    private static class Kruskal {

        // private
        final int[] parent;

        Kruskal(int vertexCount) {
            parent = new int[vertexCount + 1];
            for (int i = 1; i <= vertexCount; i++) {
                parent[i] = i;
            }
        }

        // public
        void merge(int x, int y) {
            int tempX = find(x);
            int tempY = find(y);
            if (tempX != tempY) {
                parent[tempY] = tempX;
            }
        }

        // public
        boolean isUnion(int x, int y) {
            return find(x) == find(y);
        }

        // private
        int find(int index) {
            return (parent[index] == index) ? index : (parent[index] = find(parent[index]));
        }
    }
}
