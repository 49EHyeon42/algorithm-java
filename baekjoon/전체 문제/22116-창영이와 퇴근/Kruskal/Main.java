import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dy = {1, -1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int vertexNumber = Integer.parseInt(br.readLine());

        int[][] matrix = new int[vertexNumber][vertexNumber];

        for (int y = 0; y < vertexNumber; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int x = 0; x < vertexNumber; x++) {
                matrix[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        List<Edge> edges = new ArrayList<>();

        for (int y = 0; y < vertexNumber; y++) {
            for (int x = 0; x < vertexNumber; x++) {
                for (int i = 0; i < 4; i++) {
                    int nextY = y + dy[i];
                    int nextX = x + dx[i];

                    if (!isPossibleRange(vertexNumber, nextY, nextX)) {
                        continue;
                    }

                    edges.add(new Edge(indexToVertex(vertexNumber, y, x), indexToVertex(vertexNumber, nextY, nextX), Math.abs(matrix[y][x] - matrix[nextY][nextX])));
                }
            }
        }

        edges.sort(Comparator.comparingInt(edge -> edge.weight));

        int maximumWeight = 0;

        int maximumVertexNumber = vertexNumber * vertexNumber;

        Kruskal kruskal = new Kruskal(maximumVertexNumber);

        for (Edge edge : edges) {
            if (!kruskal.isUnion(edge.vertex1, edge.vertex2)) {
                kruskal.merge(edge.vertex1, edge.vertex2);

                if (kruskal.isUnion(0, maximumVertexNumber - 1)) {
                    maximumWeight = edge.weight;
                    break;
                }
            }
        }

        bw.write(Integer.toString(maximumWeight));

        bw.flush();
        bw.close();
    }

    private static boolean isPossibleRange(int vertexNumber, int y, int x) {
        return y >= 0 && y < vertexNumber && x >= 0 && x < vertexNumber;
    }

    private static int indexToVertex(int vertexNumber, int y, int x) {
        return vertexNumber * y + x;
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

        // private
        int find(int index) {
            return (parent[index] == index) ? index : (parent[index] = find(parent[index]));
        }
    }
}
