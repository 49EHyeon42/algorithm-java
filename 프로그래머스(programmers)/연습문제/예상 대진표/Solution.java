public class Solution {

    // reference : https://school.programmers.co.kr/questions/20109
    public int solution(int n, int a, int b) {
        int answer = 0;

        int xor = a - 1 ^ b - 1;

        while (xor > 0) {
            answer++;
            xor >>= 1;
        }

        return answer;
    }
}
