class Solution {

    public int maxSubarraySumCircular(int[] nums) {
        int currentMax = Integer.MIN_VALUE;
        int currentMin = Integer.MAX_VALUE;

        int sum = 0;

        int maxSum = nums[0];
        int minSum = nums[0];

        for (int num : nums) {
            currentMax = Math.max(currentMax, 0) + num;
            maxSum = Math.max(maxSum, currentMax);
            currentMin = Math.min(currentMin, 0) + num;
            minSum = Math.min(minSum, currentMin);
            sum += num;
        }

        return sum == minSum ? maxSum : Math.max(maxSum, sum - minSum);
    }
}
