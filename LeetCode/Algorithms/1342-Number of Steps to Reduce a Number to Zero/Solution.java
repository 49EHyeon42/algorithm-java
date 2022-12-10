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
}
