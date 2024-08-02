// 다른 분 풀이 참고
class Solution2 {

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        String format = "%" + n + "s";

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String binaryString = Integer.toBinaryString(arr1[i] | arr2[i]);

            binaryString = String.format(format, binaryString);

            for (int j = 0; j < n; j++) {
                sb.append(binaryString.charAt(j) == '1' ? '#' : ' ');
            }

            answer[i] = sb.toString();

            sb.setLength(0);
        }

        return answer;
    }
}
