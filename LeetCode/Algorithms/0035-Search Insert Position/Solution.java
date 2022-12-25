public class Solution {

    // reference : https://leetcode.com/problems/search-insert-position/solutions/423166/binary-search-101/?orderBy=most_votes
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length;

        while (low < high) {
            // Overflow protection

            // when odd, return the only mid
            // when even, return the lower mid
            int mid = low + ((high - low) / 2);

            // when odd, return the only mid
            // when even, return the upper mid
            // int mid = low + ((high - low) / 2);

            if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
