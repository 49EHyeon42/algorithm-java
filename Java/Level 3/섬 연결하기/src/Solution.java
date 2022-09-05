import java.util.ArrayList;
import java.util.Comparator;

public class Solution {

    private final ArrayList<Edge> edges = new ArrayList<>();
    private int[] parent;

    public int solution(int n, int[][] costs) {
        for (int[] cost : costs) {
            edges.add(new Edge(cost[0], cost[1], cost[2]));
        }

        edges.sort(Comparator.comparingInt(Edge::getWeight));

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int minWeight = 0;
        for (Edge edge : edges) {
            if (!isUnion(edge.getVertex1(), edge.getVertex2())) {
                merge(edge.getVertex1(), edge.getVertex2());

                minWeight += edge.getWeight();
            }
        }

        return minWeight;
    }

    private boolean isUnion(int x, int y) {
        return find(x) == find(y);
    }

    private void merge(int x, int y) {
        int tempX = find(x);
        int tempY = find(y);
        if (tempX != tempY) {
            parent[tempY] = tempX;
        }
    }

    private int find(int index) {
        return (parent[index] == index) ? index : (parent[index] = find(parent[index]));
    }

    private static class Edge {

        private final int vertex1;
        private final int vertex2;
        private final int weight;

        public Edge(int vertex1, int vertex2, int weight) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
        }

        public int getVertex1() {
            return vertex1;
        }

        public int getVertex2() {
            return vertex2;
        }

        public int getWeight() {
            return weight;
        }
    }
}
