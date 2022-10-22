import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String string;
        while (!(string = br.readLine()).equals("*")) {
            sb.append(string);
            if (isSurprising(string)) {
                sb.append(" is surprising.\n");
            } else {
                sb.append(" is NOT surprising.\n");
            }
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static boolean isSurprising(String string) {
        for (int i = 1; i < string.length() - 1; i++) {
            HashSet<String> hashSet = new HashSet<>();

            for (int j = 0; j < string.length() - i; j++) {
                String pair = "" + string.charAt(j) + string.charAt(j + i);

                if (hashSet.contains(pair)) {
                    return false;
                } else {
                    hashSet.add(pair);
                }
            }
        }

        return true;
    }
}
