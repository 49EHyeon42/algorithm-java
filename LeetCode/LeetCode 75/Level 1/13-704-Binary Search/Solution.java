class Solution {

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start + 1) / 2; // 오버플로우 방지

            if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }

        return (nums[start] == target) ? start : -1;
    }
}
