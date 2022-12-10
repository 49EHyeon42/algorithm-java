class Solution {

    // iterative approach
    public int numberOfSteps(int num) {
        int step = 0;

        while (num != 0) {
            step++;
            num = (num % 2 == 0) ? num / 2 : num - 1;
        }

        return step;
    }

    // recursive approach
    public int numberOfSteps2(int num) {
        return (num == 0) ? 0 : 1 + numberOfSteps((num % 2 == 0) ? num / 2 : num - 1);
    }

    // Bitwise operation
    // link: https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/solutions/907422/java-0ms-1-liner-avoid-recursion-iteration-with-integer-library/
    public int numberOfSteps(int num) {
        return Integer.toBinaryString(num).length() - 1 + Integer.bitCount(num);
    }
}
