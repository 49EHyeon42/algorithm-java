class Solution {

    public int solution(int n) {
        return convertBase3ToBase10(convertBase3Reverse(n));
    }

    private String convertBase3Reverse(int number) {
        StringBuilder sb = new StringBuilder();

        while (number > 0) {
            sb.append(number % 3);
            number /= 3;
        }

        return sb.toString();
    }

    private int convertBase3ToBase10(String base3) {
        int sum = 0;

        for (int i = 0; i < base3.length(); i++) {
            sum = sum * 3 + (base3.charAt(i) - '0');
        }

        return sum;
    }
}
