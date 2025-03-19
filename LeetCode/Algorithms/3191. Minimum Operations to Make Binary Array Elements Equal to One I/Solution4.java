class Solution {

    public int minOperations(int[] nums) {
        int count = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] != 0) {
                continue;
            }

            count++;

            nums[i - 1] = 1;
            nums[i] ^= 1;
            nums[i + 1] ^= 1;
        }

        return nums[nums.length - 2] == 0 || nums[nums.length - 1] == 0 ? -1 : count;
    }
}
