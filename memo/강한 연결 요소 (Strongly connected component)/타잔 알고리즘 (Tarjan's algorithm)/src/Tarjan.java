import java.util.ArrayList;
import java.util.Stack;

public class Tarjan {

    private final ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    private final Stack<Integer> stack = new Stack<>();

    private int discoveredCount = 0;
    private int sccCount = 0;

    private final int[] discovered;

    private final boolean[] finished;

    private final int[] scc;

    public Tarjan(int vertexCount) {
        for (int i = 0; i <= vertexCount; i++) {
            graph.add(new ArrayList<>());
        }

        discovered = new int[vertexCount + 1];

        finished = new boolean[vertexCount + 1];

        scc = new int[vertexCount + 1];
    }

    public void addEdge(int vertex1, int vertex2) {
        graph.get(vertex1).add(vertex2);
    }

    public int dfs(int startVertex) {
        int parent = discovered[startVertex] = discoveredCount++;

        stack.push(startVertex);

        for (int nextVertex : graph.get(startVertex)) {
            if (discovered[nextVertex] == 0) {
                parent = Math.min(parent, dfs(nextVertex));
            } else if (!finished[nextVertex]) {
                parent = Math.min(parent, discovered[nextVertex]);
            }
        }

        if (discovered[startVertex] == parent) {
            while (true) {
                int temp = stack.pop();

                scc[temp] = sccCount;

                finished[temp] = true;

                if (startVertex == temp) {
                    break;
                }
            }

            sccCount++;
        }

        return parent;
    }

    public int[] getDiscovered() {
        return discovered;
    }

    public int[] getScc() {
        return scc;
    }
}
