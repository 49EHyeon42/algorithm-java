import java.util.HashSet;

public class Solution {

    public int solution(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int num : nums) {
            hashSet.add(num);
        }

        return Math.min(nums.length / 2, hashSet.size());
    }
}
