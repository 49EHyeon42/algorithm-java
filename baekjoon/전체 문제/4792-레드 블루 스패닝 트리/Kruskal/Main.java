import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        List<Edge> edges = new ArrayList<>();

        Kruskal kruskal = new Kruskal();

        while (true) {
            edges.clear();

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0 && k == 0) {
                break;
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                edges.add(new Edge(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            // B -> R
            edges.sort(Comparator.comparingInt(edge -> edge.color));

            int maxBlue = getWeight(n, kruskal, edges);

            // R -> B
            Collections.reverse(edges);

            int minBlue = getWeight(n, kruskal, edges);

            sb.append(minBlue <= k && k <= maxBlue ? 1 : 0).append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    private static int getWeight(int n, Kruskal kruskal, List<Edge> edges) {
        int weight = 0;

        kruskal.init(n);

        for (Edge edge : edges) {
            if (!kruskal.isUnion(edge.vertex1, edge.vertex2)) {
                kruskal.merge(edge.vertex1, edge.vertex2);

                if (edge.color == 'B') {
                    weight++;
                }
            }
        }

        return weight;
    }

    private static class Edge {

        final char color;
        final int vertex1;
        final int vertex2;

        Edge(char color, int vertex1, int vertex2) {
            this.color = color;
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
        }
    }

    private static class Kruskal {

        // private
        int[] parent;

        public void init(int numberOfVertices) {
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
