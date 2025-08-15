class Solution1 {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        // N * O(N)
        // 시간 초과
        for (int i = 1; i <= number; i++) {
            int divisorCount = getDivisorCount(i);
            
            answer += divisorCount > limit ? power : divisorCount;
        }
        
        return answer;
    }
    
    // O(N)
    private int getDivisorCount(int number) {
        int count = 0;
        
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        
        return count;
    }
}
