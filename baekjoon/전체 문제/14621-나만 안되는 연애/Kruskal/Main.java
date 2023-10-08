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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertexNumber = Integer.parseInt(st.nextToken());
        int edgeNumber = Integer.parseInt(st.nextToken());

        char[] universities = new char[vertexNumber + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= vertexNumber; i++) {
            universities[i] = st.nextToken().charAt(0);
        }

        for (int i = 0; i < edgeNumber; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if ((universities[vertex1] == 'M' && universities[vertex2] == 'M') || (universities[vertex1] == 'W' && universities[vertex2] == 'W')) {
                continue;
            }

            edges.add(new Edge(vertex1, vertex2, weight));
        }

        edges.sort(Comparator.comparingInt(vertex -> vertex.weight));

        Kruskal kruskal = new Kruskal(vertexNumber);

        int totalWeight = 0;

        for (Edge edge : edges) {
            if (!kruskal.isUnion(edge.vertex1, edge.vertex2)) {
                kruskal.merge(edge.vertex1, edge.vertex2);

                totalWeight += edge.weight;
            }
        }

        bw.write(Integer.toString(kruskal.isUnionAll() ? totalWeight : -1));

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

        // public
        boolean isUnionAll() {
            int p = parent[1];

            for (int i = 2; i < parent.length; i++) {
                if (!isUnion(p, i)) {
                    return false;
                }
            }

            return true;
        }

        // private
        int find(int index) {
            return (parent[index] == index) ? index : (parent[index] = find(parent[index]));
        }
    }
}
