class Solution {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }

        int count = 0;

        for (int right = 0, left = 0, product = 1; right < nums.length; right++) {

            product *= nums[right];

            while (left <= right && product >= k) {
                product /= nums[left++];
            }

            count += right - left + 1;
        }

        return count;
    }
}
