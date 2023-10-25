import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        List<Point> points = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int weight = getWeight(points.get(i), points.get(j));

                if (weight < C) {
                    continue;
                }

                edges.add(new Edge(i, j, weight));
            }
        }

        edges.sort(Comparator.comparingInt(vertex -> vertex.weight));

        bw.write(Integer.toString(getResult(N, edges)));

        bw.flush();
        bw.close();
    }

    private static int getWeight(Point point1, Point point2) {
        int temp1 = point1.x - point2.x;
        int temp2 = point1.y - point2.y;

        return temp1 * temp1 + temp2 * temp2;
    }

    private static int getResult(int N, List<Edge> edges) {
        int result = 0;

        Kruskal kruskal = new Kruskal(N);

        for (Edge edge : edges) {
            if (!kruskal.isUnion(edge.vertex1, edge.vertex2)) {
                kruskal.merge(edge.vertex1, edge.vertex2);

                result += edge.weight;
            }
        }

        return kruskal.isUnionAll() ? result : -1;
    }

    private static class Kruskal {

        // private
        int[] parent;

        public Kruskal(int numberOfVertices) {
            parent = new int[numberOfVertices];
            for (int i = 0; i < numberOfVertices; i++) {
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

        boolean isUnionAll() {
            int p = 0;

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

    private static class Point {

        final int x;
        final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
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
}
