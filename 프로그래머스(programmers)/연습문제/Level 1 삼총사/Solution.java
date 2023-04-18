public class Solution {

    private int length;

    private int[] numbers;
    private boolean[] visited;

    private int answer;

    public int solution(int[] numbers) {
        this.length = numbers.length;

        this.numbers = numbers;
        this.visited = new boolean[length];

        combination(0, 3);

        return answer;
    }

    // Backtracking, nCr
    private void combination(int start, int r) {
        if (r == 0) {
            int sum = 0;

            for (int i = 0; i < length; i++) {
                if (visited[i]) {
                    sum += numbers[i];
                }
            }

            if (sum == 0) {
                answer++;
            }
        }

        for (int i = start; i < length; i++) {
            visited[i] = true;
            combination(i + 1, r - 1);
            visited[i] = false;
        }
    }
}
