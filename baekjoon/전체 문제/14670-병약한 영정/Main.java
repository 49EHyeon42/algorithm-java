import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            map.put(st.nextToken(), st.nextToken());
        }

        int R = Integer.parseInt(br.readLine());

        for (int i = 0; i < R; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int L = Integer.parseInt(st.nextToken());

            StringBuilder sb2 = new StringBuilder();

            for (int j = 0; j < L; j++) {
                String result = map.get(st.nextToken());

                if (result != null) {
                    sb2.append(result).append(' ');
                } else {
                    sb2.setLength(0);
                    sb2.append("YOU DIED");

                    break;
                }
            }

            sb.append(sb2).append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}
