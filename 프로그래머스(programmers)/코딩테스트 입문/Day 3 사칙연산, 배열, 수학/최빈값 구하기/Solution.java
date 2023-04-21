public class Solution {

    public int solution(int[] array) {
        int[] counts = new int[1000 + 1];

        for (int i : array) {
            counts[i]++;
        }

        int answer = -1;
        int maxCount = -1;
        boolean IsDuplicate = false;

        for (int i = 0; i < counts.length; i++) {
            if (maxCount < counts[i]) {
                answer = i;
                maxCount = counts[i];
                IsDuplicate = false;
            } else if (maxCount == counts[i]) {
                IsDuplicate = true;
            }
        }

        return (IsDuplicate) ? -1 : answer;
    }
}
