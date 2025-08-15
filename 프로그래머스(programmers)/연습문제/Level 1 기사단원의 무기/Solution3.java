class Solution3 {
    public int solution(int number, int limit, int power) {
        // 약수 개수들
        int[] divisors = new int[number + 1];

        // O(N log N)
        for (int i = 1; i <= number; i++) {
            for (int j = i; j <= number; j += i) {
                divisors[j]++;
            }
        }

        int answer = 0;

        // O(N)
        for (int i = 1; i <= number; i++) {
            answer += divisors[i] > limit ? power : divisors[i];
        }

        return answer;
    }
}
