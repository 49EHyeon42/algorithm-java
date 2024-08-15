// memo: 에라토스테네스의 체도 해봤으나 Long 타입으로 인해 오히려 악영향

class Solution {
    
    public int solution(int n, int k) {
        String[] split = convertBaseK(n, k).split("0");

        int answer = 0;

        for (String string : split) {
            if (string.isEmpty()) {
                continue;
            }

            // memo: long 타입 주의
            if (isPrimeNumber(Long.parseLong(string))) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPrimeNumber(long number) {
        if (number < 2) {
            return false;
        }

        if (number == 2) {
            return true;
        }

        if (number % 2 == 0) {
            return false;
        }

        long max = (long) Math.sqrt(number);

        for (int i = 3; i <= max; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    private String convertBaseK(int n, int k) {
        StringBuilder sb = new StringBuilder();

        while (n != 0) {
            sb.append(n % k);
            n /= k;
        }

        return sb.reverse().toString();
    }
}
