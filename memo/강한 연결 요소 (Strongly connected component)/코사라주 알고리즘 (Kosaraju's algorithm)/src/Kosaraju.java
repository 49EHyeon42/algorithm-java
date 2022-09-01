import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Kosaraju {
    // 2개의 그래프, 1개의 스택

    private final ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private final ArrayList<ArrayList<Integer>> reverseGraph = new ArrayList<>();

    private final boolean[] isVisited;

    private final Stack<Integer> stack = new Stack<>();

    private final int[] scc;

    public Kosaraju(int vertexCount) {
        for (int i = 0; i <= vertexCount; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        isVisited = new boolean[vertexCount + 1];

        scc = new int[vertexCount + 1];
    }

    // 순방향, 역방향 그래프 간선 넣기
    public void addEdge(int vertex1, int vertex2) {
        graph.get(vertex1).add(vertex2);
        reverseGraph.get(vertex2).add(vertex1);
    }

    // 순방향, 역방향 그래프 정렬
    public void graphSort() {
        for (int i = 1; i < graph.size(); i++) {
            graph.get(i).sort(Comparator.reverseOrder());
            reverseGraph.get(i).sort(Comparator.reverseOrder());
        }
    }

    // 순방향 그래프 정렬
    public void dfs(int startVertex) {
        isVisited[startVertex] = true;

        for (int i = 0; i < graph.get(startVertex).size(); i++) {
            int nextVertex = graph.get(startVertex).get(i);

            if (!isVisited[nextVertex]) {
                dfs(nextVertex);
            }
        }

        // 순방향 그래프 dfs 순서 스택에 넣기
        stack.push(startVertex);
    }

    // 방문 초기화
    public void initIsVisited() {
        Arrays.fill(isVisited, false);
    }

    // 역방향 그래프 dfs
    public void reverseDfs(int startVertex, int number) {
        isVisited[startVertex] = true;
        scc[startVertex] = number;

        for (int i = 0; i < reverseGraph.get(startVertex).size(); i++) {
            int nextVertex = reverseGraph.get(startVertex).get(i);

            if (!isVisited[nextVertex]) {
                reverseDfs(nextVertex, number);
            }
        }
    }

    public boolean[] getIsVisited() {
        return isVisited;
    }

    public Stack<Integer> getStack() {
        return stack;
    }

    public int[] getScc() {
        return scc;
    }
}
