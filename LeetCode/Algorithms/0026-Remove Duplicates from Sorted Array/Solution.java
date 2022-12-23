import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public int removeDuplicates(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().distinct().sorted(Integer::compareTo).collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }

        return list.size();
    }
}
