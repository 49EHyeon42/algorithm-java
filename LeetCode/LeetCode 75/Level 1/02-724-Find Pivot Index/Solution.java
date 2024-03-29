class Solution {

    public int pivotIndex(int[] nums) {
        int left = 0;
            int right = getSum(nums);

        for (int i = 0; i < nums.length; i++) {
            if (left == (right -= nums[i])) {
                return i;
            }
            left += nums[i];
        }

        return -1;
    }

    private int getSum(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return sum;
    }
}
