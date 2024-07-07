import java.util.*;

class Solution {

    public String solution(int n, int t, int m, int p) {
        StringBuilder result = new StringBuilder();

        StringBuilder sb = new StringBuilder(0);

        int currentNumber = 0;
        int currentIndex = 0;

        while (t > 0) {
            while (sb.length() <= currentIndex) {
                sb.append(convertToBase(currentNumber++, n));
            }

            if (currentIndex % m + 1 == p) {
                result.append(sb.charAt(currentIndex));

                t--;
            }

            currentIndex++;
        }

        return result.toString();
    }

    private String convertToBase(int number, int base) {
        if (number == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        int quotient = number;

        while (quotient > 0) {
            int remainder = quotient % base;

            if (remainder < 10) {
                sb.append(remainder);
            } else {
                sb.append((char) ('A' + remainder - 10));
            }

            quotient /= base;
        }

        return sb.reverse().toString();
    }
}
