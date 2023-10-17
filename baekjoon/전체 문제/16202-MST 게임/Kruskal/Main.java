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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertexNumber = Integer.parseInt(st.nextToken());
        int edgeNumber = Integer.parseInt(st.nextToken());
        int turnNumber = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();

        for (int i = 1; i <= edgeNumber; i++) {
            st = new StringTokenizer(br.readLine());

            edges.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i));
        }

        edges.sort(Comparator.comparingInt(edge -> edge.weight));

        Kruskal kruskal = new Kruskal(vertexNumber);

        for (int currentTurn = 0; currentTurn < turnNumber; currentTurn++) {
            if (vertexNumber - 1 > edgeNumber - currentTurn) {
                sb.append(0).append(' ');
                continue;
            }

            kruskal.init(vertexNumber);

            int minimumWeight = 0;

            for (int i = currentTurn; i < edgeNumber; i++) {
                Edge currentEdge = edges.get(i);

                if (!kruskal.isUnion(currentEdge.vertex1, currentEdge.vertex2)) {
                    kruskal.merge(currentEdge.vertex1, currentEdge.vertex2);

                    minimumWeight += currentEdge.weight;
                }
            }

            if (!kruskal.isUnionAll()) {
                minimumWeight = 0;
            }

            sb.append(minimumWeight).append(' ');
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
        int[] parent;

        Kruskal(int vertexCount) {
            init(vertexCount);
        }

        // public
        void init(int vertexCount) {
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
