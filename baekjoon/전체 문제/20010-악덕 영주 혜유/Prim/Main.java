
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

        List<List<Vertex>> graph = new ArrayList<>();
        List<List<Vertex>> newGraph = new ArrayList<>();
        for (int i = 0; i < numberOfVertices; i++) {
            graph.add(new ArrayList<>());
            newGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < numberOfEdges; i++) {
            st = new StringTokenizer(br.readLine());
            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(vertex1).add(new Vertex(vertex1, vertex2, weight));
            graph.get(vertex2).add(new Vertex(vertex2, vertex1, weight));
        }

        // Prim

        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.weight));
        pq.offer(new Vertex(0, 0, 0));

        boolean[] visited = new boolean[numberOfVertices];

        int minimumWeight = 0;

        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            if (visited[currentVertex.to]) {
                continue;
            }

            visited[currentVertex.to] = true;

            if (currentVertex.weight != 0) {
                newGraph.get(currentVertex.from).add(new Vertex(currentVertex.from, currentVertex.to, currentVertex.weight));
                newGraph.get(currentVertex.to).add(new Vertex(currentVertex.to, currentVertex.from, currentVertex.weight));
            }

            minimumWeight += currentVertex.weight;

            for (Vertex nextVertex : graph.get(currentVertex.to)) {
                if (visited[nextVertex.to]) {
                    continue;
                }

                pq.offer(nextVertex);
            }
        }

        Stack<Vertex> stack = new Stack<>();

        // 가장 먼 vertex 구하기
        dfs(newGraph, stack, new boolean[numberOfVertices], 0);

        // 마을과 마을을 이동하는 가장 큰 가중치 구하기
        maximumWeight = 0;

        dfs(newGraph, stack, new boolean[numberOfVertices], vertex);

        bw.write(minimumWeight + "\n" + maximumWeight);

        bw.flush();
        bw.close();
    }

    private static void dfs(List<List<Vertex>> graph, Stack<Vertex> stack, boolean[] visited, int startVertex) {
        // INFO vertex의 from 사용 안함

        stack.add(new Vertex(-1, startVertex, 0));

        while (!stack.isEmpty()) {
            Vertex currentVertex = stack.pop();

            if (visited[currentVertex.to]) {
                continue;
            }

            visited[currentVertex.to] = true;

            if (maximumWeight < currentVertex.weight) {
                vertex = currentVertex.to;
                maximumWeight = currentVertex.weight;
            }

            for (Vertex nextVertex : graph.get(currentVertex.to)) {
                if (visited[nextVertex.to]) {
                    continue;
                }

                stack.push(new Vertex(nextVertex.from, nextVertex.to, nextVertex.weight + currentVertex.weight));
            }
        }
    }

    private static class Vertex {

        final int from; // new graph를 만들기 위해 사용
        final int to;
        final int weight;

        Vertex(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
