import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());

            HashMap<String, Integer> firstPublicKey = new HashMap<>();
            int[] array = new int[n];
            String[] cipher = new String[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                firstPublicKey.put(st.nextToken(), i);
            }

            // second public key
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                array[i] = firstPublicKey.get(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                cipher[array[i]] = st.nextToken();
            }

            for (int i = 0; i < n; i++) {
                sb.append(cipher[i]).append(' ');
            }
            sb.append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }
}
