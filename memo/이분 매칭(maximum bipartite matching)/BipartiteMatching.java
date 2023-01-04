public class BipartiteMatching {

    private final int startVertexCount;
    private final int endVertexCount;
    private final boolean[][] graph;

    private final int[] startMatch;
    private final int[] endMatch;

    private boolean[] visited;

    public BipartiteMatching(int startVertexCount, int endVertexCount, boolean[][] graph) {
        this.startVertexCount = startVertexCount;
        this.endVertexCount = endVertexCount;
        this.graph = graph;

        startMatch = new int[startVertexCount];
        endMatch = new int[endVertexCount];

        for (int i = 0; i < startVertexCount; i++) {
            startMatch[i] = -1;
        }

        for (int i = 0; i < endVertexCount; i++) {
            endMatch[i] = -1;
        }
    }

    // 시간 복잡도 = O(정점의 수 * 간선의 수)
    public int bipartiteMatching() {
        int maximumMatchingSize = 0;

        for (int start = 0; start < startVertexCount; start++) {
            visited = new boolean[startVertexCount];

            if (dfs(start)) {
                maximumMatchingSize++;
            }
        }

        return maximumMatchingSize;
    }

    private boolean dfs(int a) {
        if (visited[a]) {
            return false;
        }

        visited[a] = true;

        for (int b = 0; b < endVertexCount; b++) {
            if (graph[a][b]) {
                if (endMatch[b] == -1 || dfs(endMatch[b])) {
                    startMatch[a] = b;
                    endMatch[b] = a;

                    return true;
                }
            }
        }

        return false;
    }

    public int[] getStartMatch() {
        return startMatch;
    }

    public int[] getEndMatch() {
        return endMatch;
    }
}
