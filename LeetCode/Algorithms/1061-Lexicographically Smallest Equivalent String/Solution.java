public class Solution {

    private final int[] parent = new int[26];

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        int length = s1.length(); // s1.length() == s2.length()
        for (int i = 0; i < length; i++) {
            merge(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        StringBuilder sb = new StringBuilder();

        length = baseStr.length();
        for (int i = 0; i < length; i++) {
            sb.append((char) (find(baseStr.charAt(i) - 'a') + 'a'));
        }

        return sb.toString();
    }

    private void merge(int x, int y) {
        int tempX = find(x);
        int tempY = find(y);

        if (tempX != tempY) {
            parent[Math.max(tempX, tempY)] = Math.min(tempX, tempY);
        }
    }

    private int find(int index) {
        return (parent[index] == index) ? index : (parent[index] = find(parent[index]));
    }

    private int find2(int index) {
        while (parent[index] != index) {
            index = parent[index];
        }
        return index;
    }
}
