public class Solution {

    public int solution(String name) {
        int answer = 0;
        int minMove = name.length() - 1;

        for (int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            int index = i + 1;
            while (index < name.length() && name.charAt(index) == 'A') {
                index++;
            }

            int temp = name.length() - index;
            minMove = Math.min(minMove, Math.min(2 * i + temp, 2 * temp + i));
        }

        return answer + minMove;
    }
}
