class Solution2 {
    public int solution(int number, int limit, int power) {
        int answer = 0;

        // N * O(루트N)
        for (int i = 1; i <= number; i++) {
            int divisorCount = getDivisorCount(i);

            answer += divisorCount > limit ? power : divisorCount;
        }

        return answer;
    }

    // O(루트N)
    private int getDivisorCount(int number) {
        int count = 0;

        for (int i = 1; i * i <= number; i++) {
            if (i * i == number) {
                count++;
            } else if (number % i == 0) {
                count += 2;
            }
        }

        return count;
    }
}
