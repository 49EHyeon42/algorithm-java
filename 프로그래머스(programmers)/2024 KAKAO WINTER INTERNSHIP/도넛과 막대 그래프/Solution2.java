import java.util.*;

// Success
class Solution2 {

    private final Map<Integer, Set<Integer>> graph = new HashMap<>();

    private final Map<Integer, Integer> from = new HashMap<>();
    private final Map<Integer, Integer> to = new HashMap<>();

    // BFS
    private final Queue<Integer> queue = new LinkedList<>();
    private final Set<Integer> visited = new HashSet<>();

    public int[] solution(int[][] edges) {
        makeGraphByEdges(edges);

        int[] answer = new int[4];

        int targetVertex = getTargetVertex();

        answer[0] = targetVertex;

        for (int nextVertex : graph.get(targetVertex)) {
            int cycle = getCycleWithBfs(nextVertex);

            if (cycle == 0) {
                answer[2]++;
            } else if (cycle == 1) {
                answer[1]++;
            } else { // cycle == 2
                answer[3]++;
            }
        }

        return answer;
    }

    private void makeGraphByEdges(int[][] edges) {
        for (int[] edge : edges) {
            Set<Integer> vertex = graph.computeIfAbsent(edge[0], key -> new HashSet<>());
            vertex.add(edge[1]);

            graph.computeIfAbsent(edge[1], key -> new HashSet<>());

            if (from.containsKey(edge[1])) {
                from.put(edge[1], from.get(edge[1]) + 1);
            } else {
                from.put(edge[1], 1);
            }
        }
    }

    private int getTargetVertex() {
        // -1이 반환되는 경우는 없다.
        int targetVertex = -1;

        int maxSize = -1;

        for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            if (from.containsKey(entry.getKey())) {
                continue;
            }

            if (maxSize >= entry.getValue().size()) {
                continue;
            }

            targetVertex = entry.getKey();

            maxSize = entry.getValue().size();
        }

        return targetVertex;
    }

    private int getCycleWithBfs(int startVertex) {
        queue.clear();
        visited.clear();

        int cycle = 0;

        queue.offer(startVertex);
        visited.add(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            for (int nextVertex : graph.get(currentVertex)) {
                if (visited.contains(nextVertex)) {
                    cycle++;
                    continue;
                }

                queue.offer(nextVertex);
                visited.add(nextVertex);
            }
        }

        return cycle;
    }
}
