class Solution {

    // 슬라이딩 윈도우
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

    // 로그 이진 탐색
    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }

        double logk = Math.log(k);
        double[] prefix = new double[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + Math.log(nums[i]);
        }

        int ans = 0;

        for (int i = 0; i < prefix.length; i++) {
            int lo = i + 1, hi = prefix.length;

            while (lo < hi) {
                int mi = lo + (hi - lo) / 2;

                if (prefix[mi] < prefix[i] + logk - 1e-9) {
                    lo = mi + 1;
                } else {
                    hi = mi;
                }
            }

            ans += lo - i - 1;
        }

        return ans;
    }
}
