class Solution {

    public int solution(int n) {
        return convertBase3ToBase10(convertBase3Reverse(n));
    }

    private String convertBase3Reverse(int number) {
        StringBuilder sb = new StringBuilder();

        while (true) {
            int quotient = number / 3;
            int remainder = number % 3;

            if (quotient == 0) {
                return sb.append(remainder).toString();
            }

            sb.append(remainder);

            number = quotient;
        }
    }

    private int convertBase3ToBase10(String string) {
        int sum = 0;

        for (int i = 0, exponent = string.length() - 1; i < string.length(); i++, exponent--) {
            sum += (string.charAt(i) - '0') * (int) Math.pow(3, exponent);
        }

        return sum;
    }
}
