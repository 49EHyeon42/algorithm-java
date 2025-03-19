class Solution {

    public int minOperations(int[] nums) {
        int count = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] == 0) {
                count++;

                nums[i - 1] = 1;
                nums[i] = nums[i] == 0 ? 1 : 0;

                if (i + 1 < nums.length) {
                    nums[i + 1] = nums[i + 1] == 0 ? 1 : 0;
                }
            }
        }

        for (int i : nums) {
            if (i == 0) {
                return -1;
            }
        }

        return count;
    }
}
