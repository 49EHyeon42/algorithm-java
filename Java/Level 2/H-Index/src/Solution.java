import java.util.Arrays;

public class Solution {

    public int solution(int[] citations) {
        Arrays.sort(citations);

        for (int h = 0; h < citations.length; h++) {
            if (citations[h] >= citations.length - h) {
                return citations.length - h;
            }
        }
        return 0;
    }
}
