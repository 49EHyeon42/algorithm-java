import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        StringBuilder T = new StringBuilder(br.readLine());

        while (S.length() != T.length()) {
            char lastChar = T.charAt(T.length() - 1);

            T.deleteCharAt(T.length() - 1);

            if (lastChar == 'B') {
                T.reverse();
            }
        }

        bw.write(Integer.toString(S.equals(T.toString()) ? 1 : 0));
        bw.flush();

        br.close();
        bw.close();
    }
}
