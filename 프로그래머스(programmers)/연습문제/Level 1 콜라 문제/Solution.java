public class Solution {

    public int solution(int a, int b, int n) {
        int answer = 0;

        while (n / a > 0) {
            int temp = n / a * b;
            answer += temp;
            n = temp + n % a;
        }

        return answer;
    }

    // Best Solution
    // return (n > b ? n - b : 0) / (a - b) * b;
}
