import java.io.*;
import java.util.*;

public class Main {

    private static int vertex = -1;
    private static int maximumWeight = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numberOfVertices = Integer.parseInt(st.nextToken());
        int numberOfEdges = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < numberOfEdges; i++) {
            st = new StringTokenizer(br.readLine());

            edges.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        edges.sort(Comparator.comparingInt(edge -> edge.weight));

        int minimumWeight = 0;

        List<List<Edge>> newGraph = new ArrayList<>();
        for (int i = 0; i < numberOfVertices; i++) {
            newGraph.add(new ArrayList<>());
        }

        // kruskal
        Kruskal kruskal = new Kruskal(numberOfVertices);

        for (Edge edge : edges) {
            if (!kruskal.isUnion(edge.vertex1, edge.vertex2)) {
                kruskal.merge(edge.vertex1, edge.vertex2);

                minimumWeight += edge.weight;

                newGraph.get(edge.vertex1).add(new Edge(edge.vertex1, edge.vertex2, edge.weight));
                newGraph.get(edge.vertex2).add(new Edge(edge.vertex2, edge.vertex1, edge.weight));
            }
        }

        Stack<Edge> stack = new Stack<>();

        // 가장 먼 vertex 구하기
        dfs(newGraph, stack, new boolean[numberOfVertices], 0);

        // 마을과 마을을 이동하는 가장 큰 가중치 구하기
        maximumWeight = 0;

        dfs(newGraph, stack, new boolean[numberOfVertices], vertex);

        bw.write(minimumWeight + "\n" + maximumWeight);

        bw.flush();
        bw.close();
    }

    private static void dfs(List<List<Edge>> graph, Stack<Edge> stack, boolean[] visited, int startVertex) {
        // INFO edge의 vertex1 사용 안함

        stack.add(new Edge(-1, startVertex, 0));

        while (!stack.isEmpty()) {
            Edge currentEdge = stack.pop();

            if (visited[currentEdge.vertex2]) {
                continue;
            }

            visited[currentEdge.vertex2] = true;

            if (maximumWeight < currentEdge.weight) {
                vertex = currentEdge.vertex2;
                maximumWeight = currentEdge.weight;
            }

            for (Edge nextEdge : graph.get(currentEdge.vertex2)) {
                if (visited[nextEdge.vertex2]) {
                    continue;
                }

                stack.push(new Edge(nextEdge.vertex1, nextEdge.vertex2, nextEdge.weight + currentEdge.weight));
            }
        }
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
