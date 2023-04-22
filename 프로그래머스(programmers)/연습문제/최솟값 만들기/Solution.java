import java.util.Arrays;

public class Solution {

    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;

        for (int i = 0, j = B.length - 1; i < A.length; i++, j--) {
            answer += A[i] * B[j];
        }

        return answer;
    }
}
