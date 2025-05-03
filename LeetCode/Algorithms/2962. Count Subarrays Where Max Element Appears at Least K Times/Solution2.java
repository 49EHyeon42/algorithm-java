class Solution {

    public long countSubarrays(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }

        int max = -1;
        int maxCount = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxCount = 1;
            } else if (nums[i] == max) {
                maxCount++;
            }
        }

        if (maxCount < k) {
            return 0;
        }

        long result = 0;

        for (int start = 0, end = 0, count = 0; end < nums.length; end++) {
            if (nums[end] == max) {
                count++;
            }

            while (count >= k) {
                if (nums[start] == max) {
                    count--;
                }

                start++;
            }

            result += start;
        }

        return result;
    }
}
