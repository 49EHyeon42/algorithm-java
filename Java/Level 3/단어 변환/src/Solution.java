import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int solution(String begin, String target, String[] words) {
        if (Arrays.stream(words).noneMatch(target::equals)) {
            return 0;
        }

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= words.length; i++) {
            graph.add(new ArrayList<>());
        }
        int[] isVisited = new int[words.length + 1];

        int targetIndex = 0;
        for (int i = 0; i < words.length; i++) {
            if (target.equals(words[i])) {
                targetIndex = i + 1;
                break;
            }
        }

        for (int i = 0; i < words.length; i++) {
            if (isPossible(begin, words[i])) {
                graph.get(0).add(i + 1);
            }
        }

        for (int i = 1; i <= words.length; i++) {
            for (int j = 1; j <= words.length; j++) {
                if (isPossible(words[i - 1], words[j - 1])) {
                    graph.get(i).add(j);
                }
            }
        }

        return bfs(graph, isVisited, targetIndex);
    }

    private boolean isPossible(String string1, String string2) {
        int differenceCount = 0;
        for (int i = 0; i < string1.length(); i++) { // string1.length() == string2.length()
            if (string1.charAt(i) != string2.charAt(i)) {
                differenceCount++;
            }

            if (differenceCount > 1) {
                return false;
            }
        }

        return differenceCount == 1;
    }

    private int bfs(ArrayList<ArrayList<Integer>> graph, int[] isVisited, int targetIndex) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        isVisited[0] = 0;

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            for (int nextVertex : graph.get(currentVertex)) {
                if (isVisited[nextVertex] == 0) {
                    queue.offer(nextVertex);
                    isVisited[nextVertex] = isVisited[currentVertex] + 1;
                }
            }
        }

        return isVisited[targetIndex];
    }
}
