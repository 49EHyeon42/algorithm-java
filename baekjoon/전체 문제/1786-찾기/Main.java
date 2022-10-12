import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String T = br.readLine();
        String P = br.readLine();

        ArrayList<Integer> indexes = search(T, P);

        StringBuilder sb = new StringBuilder();
        sb.append(indexes.size()).append('\n');
        for (Integer index : indexes) {
            sb.append(index + 1).append(' ');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    public static ArrayList<Integer> search(String text, String pattern) {
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

    private static int[] getPi(String pattern) {
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
