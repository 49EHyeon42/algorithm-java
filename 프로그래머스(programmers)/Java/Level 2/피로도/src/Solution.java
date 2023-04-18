public class Solution {

    private int answer = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] isVisited = new boolean[dungeons.length];

        dfs(dungeons, isVisited, k, 0);

        return answer;
    }

    // Backtracking
    private void dfs(int[][] dungeons, boolean[] isVisited, int currentVertex, int depth) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!isVisited[i] && dungeons[i][0] <= currentVertex) {
                isVisited[i] = true;
                dfs(dungeons, isVisited, currentVertex - dungeons[i][1], depth + 1);
                isVisited[i] = false;
            }
        }

        answer = Math.max(answer, depth);
    }
}
