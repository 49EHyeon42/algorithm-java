import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int vertexNumber = Integer.parseInt(br.readLine());

        List<Edge> edges = new ArrayList<>();

        long totalWeight = 0;

        for (int i = 0; i < vertexNumber; i++) {
            String string = br.readLine();

            for (int j = 0; j < vertexNumber; j++) {
                char c = string.charAt(j);

                int weight;
                if ('a' <= c && c <= 'z') {
                    weight = c - 96;
                } else if ('A' <= c && c <= 'Z') {
                    weight = c - 38;
                } else { // c == '0'
                    weight = 0;
                }

                totalWeight += weight;

                if (weight == 0 || i == j) {
                    continue;
                }

                edges.add(new Edge(i, j, weight));
            }
        }

        long minimumWeight = 0;

        edges.sort(Comparator.comparingInt(vertex -> vertex.weight));

        Kruskal kruskal = new Kruskal(vertexNumber);

        for (Edge edge : edges) {
            if (!kruskal.isUnion(edge.vertex1, edge.vertex2)) {
                kruskal.merge(edge.vertex1, edge.vertex2);

                minimumWeight += edge.weight;
            }
        }

        bw.write(Long.toString(kruskal.isUnionAll() ? totalWeight - minimumWeight : -1));

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

        // public
        boolean isUnionAll() {
            int p = parent[0];

            for (int i = 1; i < parent.length; i++) {
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
