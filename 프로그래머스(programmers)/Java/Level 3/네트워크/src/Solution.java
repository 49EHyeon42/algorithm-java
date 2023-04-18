public class Solution {

    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] isVisited = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited[i] && computers[i][j] == 1) {
                    answer++;
                    dfs(computers, isVisited, j);
                }
            }
        }

        return answer;
    }

    private void dfs(int[][] computers, boolean[] isVisited, int currentVertex) {
        isVisited[currentVertex] = true;

        for (int i = 0; i < computers[currentVertex].length; i++) {
            if (!isVisited[i] && computers[currentVertex][i] == 1) {
                dfs(computers, isVisited, i);
            }
        }
    }
}
