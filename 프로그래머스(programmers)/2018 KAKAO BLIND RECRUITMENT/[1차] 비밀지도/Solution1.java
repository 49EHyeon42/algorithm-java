// 첫 풀이
class Solution1 {

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            answer[i] = convertMap(n, arr1[i], arr2[i]);
        }

        return answer;
    }

    private String convertMap(int n, int number1, int number2) {
        StringBuilder sb = new StringBuilder();

        String binaryString1 = Integer.toBinaryString(number1);
        String binaryString2 = Integer.toBinaryString(number2);

        binaryString1 = String.format("%" + n + "s", binaryString1).replace(' ', '0');
        binaryString2 = String.format("%" + n + "s", binaryString2).replace(' ', '0');

        for (int i = 0; i < binaryString1.length(); i++) {
            sb.append(binaryString1.charAt(i) == '1' || binaryString2.charAt(i) == '1' ? '#' : ' ');
        }

        return sb.toString();
    }
}
