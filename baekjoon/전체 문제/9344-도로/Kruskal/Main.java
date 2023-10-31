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

        int T = Integer.parseInt(br.readLine());

        List<Edge> edges = new ArrayList<>();

        Kruskal kruskal = new Kruskal();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            edges.clear();

            kruskal.init(N);

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                edges.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            edges.sort(Comparator.comparingInt(edge -> edge.weight));

            sb.append(getResult(kruskal, edges, p, q)).append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    private static String getResult(Kruskal kruskal, List<Edge> edges, int p, int q) {
        for (Edge edge : edges) {
            if (!kruskal.isUnion(edge.vertex1, edge.vertex2)) {
                kruskal.merge(edge.vertex1, edge.vertex2);

                if ((edge.vertex1 == p && edge.vertex2 == q) || (edge.vertex1 == q && edge.vertex2 == p)) {
                    return "YES";
                }
            }
        }

        return "NO";
    }

    private static class Edge {

        final int vertex1;
        final int vertex2;
        final int weight;

        public Edge(int vertex1, int vertex2, int weight) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
        }
    }

    private static class Kruskal {

        // private
        int[] parent;

        // public
        void init(int numberOfVertices) {
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
