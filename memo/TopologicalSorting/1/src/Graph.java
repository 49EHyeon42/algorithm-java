import java.util.ArrayList;
import java.util.Stack;

public class Graph {

    private final int vertexCount;
    private final ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private final boolean[] isVisited;
    private final Stack<Integer> stack = new Stack<>();

    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        for (int i = 0; i < vertexCount; i++) {
            graph.add(new ArrayList<>());
        }
        isVisited = new boolean[vertexCount + 1];
    }

    public void addEdge(int vertex1, int vertex2) {
        graph.get(vertex1).add(vertex2);
    }

    public void topologicalSort() {
        for (int i = 0; i < vertexCount; i++) {
            if (!isVisited[i]) {
                recursive(i);
            }
        }
    }

    private void recursive(int currentVertex) {
        isVisited[currentVertex] = true;
        for (int nextVertex : graph.get(currentVertex)) {
            if (!isVisited[nextVertex]) {
                recursive(nextVertex);
            }
        }
        stack.push(currentVertex);
    }

    public void printResult() {
        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + " ");
        }
    }
}
