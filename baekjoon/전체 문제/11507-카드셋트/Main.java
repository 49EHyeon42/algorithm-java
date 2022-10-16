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

        int[] cardNumber = new int[]{13, 13, 13, 13};

        String string = br.readLine();

        HashSet<String> hashSet = new HashSet<>();

        boolean flag = false;

        for (int i = 0; i < string.length() - 2; i += 3) {
            String subString = string.substring(i, i + 3);

            if (hashSet.contains(subString)) {
                flag = true;
                break;
            }

            hashSet.add(subString);

            char pattern = subString.charAt(0);

            if (pattern == 'P') {
                cardNumber[0]--;
            } else if (pattern == 'K') {
                cardNumber[1]--;
            } else if (pattern == 'H') {
                cardNumber[2]--;
            } else { // pattern == 'T'
                cardNumber[3]--;
            }
        }

        if (flag) {
            sb.append("GRESKA");
        } else {
            for (int i : cardNumber) {
                sb.append(i).append(' ');
            }
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }
}
