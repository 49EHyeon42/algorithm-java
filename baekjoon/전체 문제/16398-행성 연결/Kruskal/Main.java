import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final List<Edge> edges = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int vertexNumber = Integer.parseInt(br.readLine());

        // 양방향 그래프
        for (int i = 0; i < vertexNumber; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < vertexNumber; j++) {
                if (i <= j) {
                    st.nextToken();
                    continue;
                }

                edges.add(new Edge(i, j, Integer.parseInt(st.nextToken())));
            }
        }

        edges.sort(Comparator.comparingInt(edge -> edge.weight));

        Kruskal kruskal = new Kruskal(vertexNumber);

        long totalWeight = 0;

        for (Edge edge : edges) {
            if (!kruskal.isUnion(edge.vertex1, edge.vertex2)) {
                kruskal.merge(edge.vertex1, edge.vertex2);

                totalWeight += edge.weight;
            }
        }

        bw.write(Long.toString(totalWeight));

        bw.flush();
        bw.close();
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
            parent = new int[vertexCount];
            for (int i = 0; i < vertexCount; i++) {
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
