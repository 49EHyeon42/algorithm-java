import java.util.Arrays;

public class Solution {

    public int solution(int[] array) {
        Arrays.sort(array);
        
        return array[array.length / 2];
    }
}
