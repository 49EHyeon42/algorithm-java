import java.util.ArrayList;
import java.util.Comparator;

public class Solution {

    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (int[] command : commands) {
            ArrayList<Integer> temp = new ArrayList<>();

            for (int i = command[0] - 1; i < command[1]; i++) {
                temp.add(array[i]);
            }

            temp.sort(Comparator.comparingInt(o -> o));

            answer.add(temp.get(command[2] - 1));
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
