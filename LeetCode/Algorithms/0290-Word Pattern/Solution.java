import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean wordPattern(String pattern, String s) {
        char[] chars = pattern.toCharArray();
        String[] strings = s.split(" ");

        if (chars.length != strings.length) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                if (map.containsValue(strings[i])) {
                    return false;
                }
                map.put(chars[i], strings[i]);
            } else if (!map.get(chars[i]).equals(strings[i])) {
                return false;
            }
        }

        return true;
    }
}
