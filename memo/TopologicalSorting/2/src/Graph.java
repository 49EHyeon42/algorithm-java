import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    private final int vertexCount;
    private final int[] countOfEdge;
    private final ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    private final ArrayList<Integer> result = new ArrayList<>();

    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        countOfEdge = new int[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void addEdge(int vertex1, int vertex2) {
        countOfEdge[vertex2]++;
        graph.get(vertex1).add(vertex2);
    }

    public void topologicalSort() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < vertexCount; i++) {
            if (countOfEdge[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            result.add(currentVertex);

            for (int nextVertex : graph.get(currentVertex)) {
                countOfEdge[nextVertex]--;

                if (countOfEdge[nextVertex] == 0) {
                    queue.offer(nextVertex);
                }
            }
        }
    }

    public void printResult() {
        result.forEach(System.out::println);
    }
}
