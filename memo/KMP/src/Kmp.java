import java.util.ArrayList;

public class Kmp {

    public ArrayList<Integer> search(String text, String pattern) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        int[] pi = getPi(pattern);

        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }

            if (text.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {
                    arrayList.add(i - pattern.length() + 1);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }

        return arrayList;
    }

    private int[] getPi(String pattern) {
        int[] pi = new int[pattern.length()];

        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }

            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[i] = ++j;
            }
        }

        return pi;
    }
}
