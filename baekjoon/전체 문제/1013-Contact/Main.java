import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String pattern = "(100+1+|01)+";

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String string = br.readLine();

            sb.append((string.matches(pattern) ? "YES" : "NO")).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();
    }
}
