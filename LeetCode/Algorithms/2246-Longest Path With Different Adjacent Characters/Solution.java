import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    // official solution
    // https://leetcode.com/problems/longest-path-with-different-adjacent-characters/solutions/2889382/longest-path-with-different-adjacent-characters/

    // official solution 1, DFS
    // time complexity : O(N)
    // space complexity : O(N)
    private int longestPath = 1;

    public int longestPath(int[] parent, String s) {
        Map<Integer, List<Integer>> tree = createTree(parent);

        dfs(0, tree, s);

        return longestPath;
    }

    private Map<Integer, List<Integer>> createTree(int[] parent) {
        Map<Integer, List<Integer>> tree = new HashMap<>();

        int length = parent.length;
        for (int i = 1; i < length; i++) {
            tree.computeIfAbsent(parent[i], value -> new ArrayList<>()).add(i);
        }

        return tree;
    }

    private int dfs(int currentNode, Map<Integer, List<Integer>> children, String s) {
        if (!children.containsKey(currentNode)) {
            return 1;
        }

        int longestChain = 0;
        int secondLongestChain = 0;

        for (int child : children.get(currentNode)) {
            int longestChainStartingFromChild = dfs(child, children, s);

            if (s.charAt(currentNode) == s.charAt(child)) {
                continue;
            }

            if (longestChainStartingFromChild > longestChain) {
                secondLongestChain = longestChain;
                longestChain = longestChainStartingFromChild;
            } else if (longestChainStartingFromChild > secondLongestChain) {
                secondLongestChain = longestChainStartingFromChild;
            }
        }

        longestPath = Math.max(longestPath, longestChain + secondLongestChain + 1);

        return longestChain + 1;
    }

    // official solution 2, BFS
    // time complexity : O(N)
    // space complexity : O(N)
    public int longestPath2(int[] parent, String s) {
        int length = parent.length;

        int[] childrenCount = new int[length];

        for (int node = 1; node < length; node++) {
            childrenCount[parent[node]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[][] longestChains = new int[length][2];

        for (int node = 1; node < length; node++) {
            if (childrenCount[node] == 0) {
                queue.offer(node);
                longestChains[node][0] = 1;
            }
        }

        int longestPath = 1;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            int currentParent = parent[currentNode];

            int longestChainStartingFromCurrNode = longestChains[currentNode][0];

            if (s.charAt(currentNode) != s.charAt(currentParent)) {

                if (longestChainStartingFromCurrNode > longestChains[currentParent][0]) {
                    longestChains[currentParent][1] = longestChains[currentParent][0];
                    longestChains[currentParent][0] = longestChainStartingFromCurrNode;
                } else if (longestChainStartingFromCurrNode > longestChains[currentParent][1]) {
                    longestChains[currentParent][1] = longestChainStartingFromCurrNode;
                }
            }

            longestPath = Math.max(longestPath,
                    longestChains[currentParent][0] + longestChains[currentParent][1] + 1);

            childrenCount[currentParent]--;

            if (childrenCount[currentParent] == 0 && currentParent != 0) {
                queue.offer(currentParent);
                longestChains[currentParent][0]++;
            }
        }

        return longestPath;
    }

    // solution 3, Priority Queue
    // https://leetcode.com/problems/longest-path-with-different-adjacent-characters/solutions/1955433/java-c-python-dfs-on-tree/
    private int longestPath3 = 1;

    public int longestPath3(int[] parent, String s) {
        Map<Integer, List<Integer>> tree = createTree(parent);

        dfs3(0, tree, s);

        return longestPath3;
    }

    private int dfs3(int currentNode, Map<Integer, List<Integer>> children, String s) {
        if (!children.containsKey(currentNode)) {
            return 1;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int child : children.get(currentNode)) {
            int longestChainStartingFromChild = dfs3(child, children, s);

            if (s.charAt(currentNode) != s.charAt(child)) {
                priorityQueue.offer(longestChainStartingFromChild);
            }
        }

        int longestChain = priorityQueue.isEmpty() ? 0 : priorityQueue.poll();
        int secondLongestChain = priorityQueue.isEmpty() ? 0 : priorityQueue.poll();

        longestPath3 = Math.max(longestPath3, longestChain + secondLongestChain + 1);

        return longestChain + 1;
    }
}
