public class Solution {

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int area = brown + yellow;
        int sideLength = (int) Math.sqrt(area);

        for (int col = 3; col <= sideLength; col++) {
            if (area % col == 0) {
                int row = area / col;

                if ((col - 2) * (row - 2) == yellow) {
                    answer[0] = row;
                    answer[1] = col;
                }
            }
        }

        return answer;
    }
}
