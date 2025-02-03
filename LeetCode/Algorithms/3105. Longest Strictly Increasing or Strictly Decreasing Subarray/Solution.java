class Solution {

    public int longestMonotonicSubarray(int[] nums) {
        return Math.max(increase(nums), decrease(nums));
    }

    private int increase(int[] nums) {
        int answer = 1;

        for (int i = 1, count = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                answer = Math.max(answer, ++count);
            } else {
                count = 1;
            }
        }

        return answer;
    }

    private int decrease(int[] nums) {
        int answer = 1;

        for (int i = 1, count = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                answer = Math.max(answer, ++count);
            } else {
                count = 1;
            }
        }

        return answer;
    }
}
