import java.util.Map;

public class Solution {

    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);

        int sum = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            sum += (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) ? map.get(s.charAt(i)) : -map.get(s.charAt(i));
        }

        return sum + map.get(s.charAt(s.length() - 1));
    }

    // replace string
    public int romanToInt2(String s) {
        Map<Character, Integer> map = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);

        s = s.replace("IV", "IIII").replace("IX", "VIIII").replace("XL", "XXXX").replace("XC", "LXXXX").replace("CD", "CCCC").replace("CM", "DCCCC");

        int sum = 0;

        for (char c : s.toCharArray()) {
            sum += map.get(c);
        }

        return sum;
    }
}
