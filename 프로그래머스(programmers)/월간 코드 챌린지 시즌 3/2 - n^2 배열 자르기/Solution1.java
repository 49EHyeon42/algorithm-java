// 메모리 초과
class Solution1 {

    public int[] solution(int n, long left, long right) {
        int[][] array1 = new int[n][n];

        // setting 1
        for (int indexOrValue = n; indexOrValue >= 0; indexOrValue--) {
            for (int i = 0; i < indexOrValue; i++) {
                for (int j = 0; j < indexOrValue; j++) {
                    array1[i][j] = indexOrValue;
                }
            }
        }

        int[] array2 = new int[n * n];

        // setting 2
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array2[i * n + j] = array1[i][j];
            }
        }

        int[] answer = new int[(int) (right - left + 1)];

        for (int i = 0, j = (int) left; i < answer.length; i++, j++) {
            answer[i] = array2[j];
        }

        return answer;
    }
}
