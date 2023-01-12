import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    // official solution
    // https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/solutions/2864718/number-of-nodes-in-the-sub-tree-with-the-same-label/?orderBy=most_votes
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> graph = createGraph(edges);

        int[] answer = new int[n];

        dfs(0, -1, graph, labels, answer);

        return answer;
    }

    private int[] dfs(int node, int parent, Map<Integer, List<Integer>> graph, String labels,
            int[] answer) {
        int[] nodeCounts = new int[26];

        if (!graph.containsKey(node)) {
            return nodeCounts;
        }

        for (int child : graph.get(node)) {
            if (child == parent) {
                continue;
            }

            int[] childCounts = dfs(child, node, graph, labels, answer);

            for (int i = 0; i < 26; i++) {
                nodeCounts[i] += childCounts[i];
            }
        }

        answer[node] = ++nodeCounts[labels.charAt(node) - 'a'];

        return nodeCounts;
    }

    // solution 2
    // https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/solutions/743133/java-python-3-dfs-w-brief-explanation-and-analysis/
    public int[] countSubTrees2(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> graph = createGraph(edges);

        int[] answer = new int[n];

        dfs(graph, 0, -1, labels, answer);

        return answer;
    }

    private Map<Integer, List<Integer>> createGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        return graph;
    }

    private int[] dfs(Map<Integer, List<Integer>> graph, int node, int parent, String labels,
            int[] answer) {
        int[] count = new int[26];

        char c = labels.charAt(node);

        for (int child : graph.getOrDefault(node, Collections.emptyList())) {
            if (child != parent) {
                int[] subAnswer = dfs(graph, child, node, labels, answer);

                for (int i = 0; i < 26; ++i) {
                    count[i] += subAnswer[i];
                }
            }
        }

        answer[node] = ++count[c - 'a'];

        return count;
    }
}
