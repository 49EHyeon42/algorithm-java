public class Solution {

    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] numbers, int target, int current, int depth) {
        if (depth == numbers.length) {
            return (current == target) ? 1 : 0;
        }

        return dfs(numbers, target, current + numbers[depth], depth + 1) + dfs(numbers, target,
            current - numbers[depth], depth + 1);
    }
}
