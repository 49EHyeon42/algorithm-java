import java.util.ArrayList;
import java.util.List;

class Solution {

    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {
            list.add(score[i]);

            list.sort((j1, j2) -> j2 - j1);

            if (list.size() > k) {
                list.remove(list.size() - 1);
            }

            answer[i] = list.get(list.size() - 1);
        }

        return answer;
    }
}
