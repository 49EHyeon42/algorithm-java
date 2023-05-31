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
        String P = br.readLine();

        int count = 1;

        for (int end = 0, start = 0; end < P.length(); end++) {
            if (!S.contains(P.substring(start, end + 1))) {
                count++;
                start = end;
            }
        }

        bw.write(Integer.toString(count));
        bw.flush();

        br.close();
        bw.close();
    }
}
