public class Solution {

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = getCalculatedNumber(slow);
            fast = getCalculatedNumber(getCalculatedNumber(fast));
        } while (slow != fast);

        return slow == 1;
    }

    int getCalculatedNumber(int number) {
        int sum = 0;

        while (number > 0) {
            int temp = number % 10;
            sum += temp * temp;
            number /= 10;
        }

        return sum;
    }
}
