import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertexNumber = Integer.parseInt(st.nextToken());
        int edgeNumber = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int startVertex = Integer.parseInt(st.nextToken());
        int endVertex = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < edgeNumber; i++) {
            st = new StringTokenizer(br.readLine());

            edges.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        edges.sort((vertex1, vertex2) -> vertex2.weight - vertex1.weight);

        Kruskal kruskal = new Kruskal(vertexNumber);

        int minimumWeight = 0;

        for (Edge edge : edges) {
            if (!kruskal.isUnion(edge.vertex1, edge.vertex2)) {
                kruskal.merge(edge.vertex1, edge.vertex2);

                if (kruskal.isUnion(startVertex, endVertex)) {
                    // last weight -> minimum weight
                    minimumWeight = edge.weight;
                    break;
                }
            }
        }

        bw.write(Integer.toString(minimumWeight));

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
            for (int i = 0; i <= vertexCount; i++) {
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
