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

        // init
        int start = 0;
        int end = k - 1;
        int currentCount = 0;

        for (int i = start; i <= end; i++) {
            if (nums[i] == max) {
                currentCount++;
            }
        }

        long result = 0;

        while (true) {
            if (currentCount >= k) {
                result += (nums.length - end);

                if (nums[start] == max) {
                    currentCount--;
                }

                if (end - start + 1 < k) {
                    break;
                }

                start++;
            } else {
                if (end < nums.length - 1) {
                    end++;

                    if (nums[end] == max) {
                        currentCount++;
                    }
                } else {
                    break;
                }
            }
        }

        return result;
    }
}
