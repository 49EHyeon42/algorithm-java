import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int totalWeight = 0;

        int maximumWeight = 0;

        List<Edge> edges = new ArrayList<>();

        Kruskal kruskal = new Kruskal(N);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if (st.nextToken().equals("1")) {
                kruskal.merge(vertex1, vertex2);
            } else {
                edges.add(new Edge(vertex1, vertex2, weight));

                totalWeight += weight;
            }
        }

        edges.sort((edge1, edge2) -> edge2.weight - edge1.weight);

        for (Edge edge : edges) {
            if (!kruskal.isUnion(edge.vertex1, edge.vertex2)) {
                kruskal.merge(edge.vertex1, edge.vertex2);

                maximumWeight += edge.weight;
            }
        }

        bw.write(Integer.toString(totalWeight - maximumWeight));

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
        int[] parent;

        Kruskal(int numberOfVertices) {
            parent = new int[numberOfVertices + 1];

            for (int i = 1; i <= numberOfVertices; i++) {
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
