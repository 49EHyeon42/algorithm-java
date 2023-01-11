import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    // official solution
    // https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/solutions/2864715/minimum-time-to-collect-all-apples-in-a-tree/
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            map.computeIfAbsent(a, value -> new ArrayList<>()).add(b);
            map.computeIfAbsent(b, value -> new ArrayList<>()).add(a);
        }
        return dfs(0, -1, map, hasApple);
    }

    public int dfs(int node, int parent, Map<Integer, List<Integer>> map, List<Boolean> hasApple) {
        if (!map.containsKey(node)) {
            return 0;
        }

        int totalTime = 0;

        for (int child : map.get(node)) {
            if (child == parent) {
                continue;
            }

            int childTime = dfs(child, node, map, hasApple);

            if (childTime > 0 || hasApple.get(child)) {
                totalTime += childTime + 2;
            }
        }

        return totalTime;
    }

    // solution 2
    // https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/solutions/623673/concise-explanation-with-a-picture-for-visualization/
    public int minTime2(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> graph = createGraph(edges);
        Map<Integer, Boolean> visited = new HashMap<>();

        return dfs(graph, visited, 0, 0, hasApple);
    }

    private Map<Integer, List<Integer>> createGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            List<Integer> list = graph.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            graph.put(edge[0], list);

            list = graph.getOrDefault(edge[1], new ArrayList<>());
            list.add(edge[0]);
            graph.put(edge[1], list);
        }

        return graph;
    }

    private int dfs(Map<Integer, List<Integer>> graph, Map<Integer, Boolean> visited, int node,
            int myCost, List<Boolean> hasApple) {
        if (visited.getOrDefault(node, false)) {
            return 0;
        }

        visited.put(node, true);

        int childrenCost = 0;

        for (int n : graph.getOrDefault(node, new ArrayList<>())) {
            childrenCost += dfs(graph, visited, n, 2, hasApple);
        }

        if (childrenCost == 0 && !hasApple.get(node)) {
            return 0;
        }

        return childrenCost + myCost;
    }
}
