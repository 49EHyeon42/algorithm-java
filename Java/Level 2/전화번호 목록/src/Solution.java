import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    public boolean solution(String[] phone_book) {
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(phone_book));

        for (String string : phone_book) {
            for (int i = 0; i < string.length(); i++) {
                if (hashSet.contains(string.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;
    }
}
