import java.util.ArrayList;

public class BruteForce {

    public ArrayList<Integer> search(String text, String pattern) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == pattern.charAt(0) && isSame(text, pattern, i)) {
                arrayList.add(i);
            }
        }

        return arrayList;
    }

    private boolean isSame(String text, String pattern, int index) {
        for (int i = 0; i < pattern.length(); i++, index++) {
            if (text.charAt(index) != pattern.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
