public class Solution {

    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int lcm = denom1 * denom2 / gcd(denom1, denom2);

        int[] answer = {numer1 * lcm / denom1 + numer2 * lcm / denom2, lcm};

        int gcd = gcd(answer[0], answer[1]);

        if (gcd != 1) {
            answer[0] /= gcd;
            answer[1] /= gcd;
        }

        return answer;
    }

    private int gcd(int number1, int number2) {
        return (number2 == 0) ? number1 : gcd(number2, number1 % number2);
    }
}
