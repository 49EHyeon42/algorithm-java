
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int numberOfVertices = Integer.parseInt(br.readLine());

        List<Edge> edges = new ArrayList<>();

        for (int i = 1; i < numberOfVertices; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1 + i; j <= numberOfVertices; j++) {
                edges.add(new Edge(i, j, Integer.parseInt(st.nextToken())));
            }
        }

        edges.sort(Comparator.comparingInt(edge -> edge.weight));

        // Kruskal

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= numberOfVertices; i++) {
            graph.add(new ArrayList<>());
        }

        Kruskal kruskal = new Kruskal(numberOfVertices);

        for (Edge edge : edges) {
            if (!kruskal.isUnion(edge.vertex1, edge.vertex2)) {
                kruskal.merge(edge.vertex1, edge.vertex2);

                graph.get(edge.vertex1).add(edge.vertex2);
                graph.get(edge.vertex2).add(edge.vertex1);
            }
        }

        for (int i = 1; i <= numberOfVertices; i++) {
            graph.get(i).sort(Comparator.comparingInt(vertex -> vertex));

            sb.append(graph.get(i).size()).append(" ");

            for (int j : graph.get(i)) {
                sb.append(j).append(" ");
            }

            sb.append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    private static class Edge {

        final int vertex1;
        final int vertex2;
        final int weight;

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
