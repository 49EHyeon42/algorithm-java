public class t {

    public static void main(String[] args) {
        int vertexCount = 0;
        int edgeCount = 0;

        // Adjacency Matrix
        boolean[][] graph = new boolean[vertexCount][vertexCount];

        for (int i = 0; i < edgeCount; i++) {
            int temp1 = 0;
            int temp2 = 0;
            graph[temp1][temp2] = true;
            graph[temp2][temp1] = true;
        }
    }
}
