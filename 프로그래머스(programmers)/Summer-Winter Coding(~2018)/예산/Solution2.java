import java.util.Arrays;

// 성공
class Solution2 {

    public int solution(int[] d, int budget) {
        Arrays.sort(d);

        int count = 0;

        for (int i = 0, sum = 0; i < d.length; i++) {
            sum += d[i];

            if (sum <= budget) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}
