import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    private static final ArrayList<Edge> edges = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int vertexNumber = Integer.parseInt(st.nextToken());
            int edgeNumber = Integer.parseInt(st.nextToken());

            if (vertexNumber == 0 && edgeNumber == 0) {
                break;
            }

            edges.clear();

            for (int i = 0; i < edgeNumber; i++) {
                st = new StringTokenizer(br.readLine());
                int vertex1 = Integer.parseInt(st.nextToken());
                int vertex2 = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                edges.add(new Edge(vertex1, vertex2, weight));
            }

            edges.sort(Comparator.comparingInt(edge -> edge.weight));

            Kruskal kruskal = new Kruskal(vertexNumber);

            int totalWeight = 0;

            for (Edge edge : edges) {
                if (!kruskal.isUnion(edge.vertex1, edge.vertex2)) {
                    kruskal.merge(edge.vertex1, edge.vertex2);
                } else {
                    totalWeight += edge.weight;
                }
            }

            sb.append(totalWeight).append('\n');
        }

        bw.write(sb.toString().trim());

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

        // private
        int find(int index) {
            return (parent[index] == index) ? index : (parent[index] = find(parent[index]));
        }
    }
}
