import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static final int[][][] dpArray = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str.equals("-1 -1 -1")) {
                break;
            }

            StringTokenizer st = new StringTokenizer(str);

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c)
                .append(") = ").append(w(a, b, c)).append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    public static int w(int a, int b, int c) {

        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        } else if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        if (dpArray[a][b][c] != 0) {
            return dpArray[a][b][c];
        } else if (a < b && b < c) {
            dpArray[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1)
                - w(a, b - 1, c);
        } else {
            dpArray[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c)
                + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }
        return dpArray[a][b][c];
    }
}
