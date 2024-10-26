import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String string = br.readLine();

        char[] ucpc = new char[]{'U', 'C', 'P', 'C'};

        int index = 0;

        for (int i = 0; i < string.length() && index < 4; i++) {
            if (string.charAt(i) == ucpc[index]) {
                index++;
            }
        }

        bw.write(index == 4 ? "I love UCPC" : "I hate UCPC");

        bw.flush();
        bw.close();
    }
}
