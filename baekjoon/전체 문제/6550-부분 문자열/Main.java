import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String string;

        while ((string = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(string);
            String s = st.nextToken();
            String t = st.nextToken();

            int index = 0;

            for (int i = 0; i < t.length() && index < s.length(); i++) {
                if (s.charAt(index) == t.charAt(i)) {
                    index++;
                }
            }

            sb.append(index == s.length() ? "Yes" : "No").append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}
