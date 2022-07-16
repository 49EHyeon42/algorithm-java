public class Graph {

    private final int INF = Integer.MAX_VALUE;

    private final int vertexNumber;

    private final int[][] graph;

    public Graph(int vertexNumber) {
        this.vertexNumber = vertexNumber;
        graph = new int[vertexNumber + 1][vertexNumber + 1];
        for (int i = 1; i <= vertexNumber; i++) {
            for (int j = 1; j <= vertexNumber; j++) {
                graph[i][j] = (i == j) ? 0 : INF;
            }
        }
    }

    public void add(int startVertex, int endVertex, int weight) {
        graph[startVertex][endVertex] = weight;
    }

    public void floydWarshall() {
        for (int k = 1; k <= vertexNumber; k++) {
            for (int i = 1; i <= vertexNumber; i++) {
                for (int j = 1; j <= vertexNumber; j++) {
                    if (graph[i][k] != INF && graph[k][j] != INF) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
        }
    }

    public int[][] getGraph() {
        return graph;
    }
}
