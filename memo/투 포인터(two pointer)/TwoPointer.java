/*
 * 투 포인터(Two Pointer) 알고리즘
 *
 * 배열의 특정 연속된 구간을 처리하는 경우 사용
 * 리스트에 순차적으로 접근해야 할 때 사용
 *
 * 시간복잡도 = O(N)
 * */
public class TwoPointer {

    /*
     * @param   array   배열
     * @param   M       특정 값
     * @return          특정값과 부분 연속 수열 합이 같은 수
     * */
    public int Solution(int[] array, int M) {
        int count = 0;
        for (int start = 0; start < array.length; start++) {
            int end = start + 1;

            while (end < array.length) {
                int sum = array[start] + array[end++];

                if (sum == M) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }
}
