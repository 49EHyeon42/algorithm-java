import java.util.ArrayList;

public class Solution {

    public int solution(String numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] isVisited = new boolean[numbers.length()];

        String next = "";
        for (int i = 0; i < numbers.length(); i++) {
            backtracking(list, isVisited, numbers, next, i + 1);
        }

        int answer = 0;
        for (int number : list) {
            if (isPrimeNumber(number)) {
                answer++;
            }
        }

        return answer;
    }

    private void backtracking(ArrayList<Integer> list, boolean[] isVisited, String current,
        String next, int depth) {
        if (depth == next.length()) {
            int nextToInt = Integer.parseInt(next);

            if (!list.contains(nextToInt)) {
                list.add(nextToInt);
            }
            return;
        }

        for (int i = 0; i < current.length(); i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                next += current.charAt(i);
                backtracking(list, isVisited, current, next, depth);
                isVisited[i] = false;
                next = next.substring(0, next.length() - 1);
            }
        }
    }

    private boolean isPrimeNumber(int number) {
        if (number == 0 || number == 1) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
