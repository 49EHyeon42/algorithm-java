import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static String S;

    private static boolean flag;

    private static void solution(String T) {
        if (T.length() == S.length()) {
            if (T.equals(S)) {
                flag = true;
            }

            return;
        }

        if (T.charAt(T.length() - 1) == 'A') {
            solution(new StringBuilder(T).deleteCharAt(T.length() - 1).toString());
        }

        if (T.charAt(0) == 'B') {
            solution((new StringBuilder(T).reverse().deleteCharAt(T.length() - 1).toString()));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        S = br.readLine();
        String T = br.readLine();

        solution(T);

        bw.write(Integer.toString(flag ? 1 : 0));
        bw.flush();

        br.close();
        bw.close();
    }
}
