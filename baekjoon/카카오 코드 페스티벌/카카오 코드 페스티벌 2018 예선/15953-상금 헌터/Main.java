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

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(get2017(a) + get2018(b)).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();
    }

    private static int get2017(int ranking) {
        if (ranking == 1) {
            return 5000000;
        } else if (2 <= ranking && ranking <= 3) {
            return 3000000;
        } else if (4 <= ranking && ranking <= 6) {
            return 2000000;
        } else if (7 <= ranking && ranking <= 10) {
            return 500000;
        } else if (11 <= ranking && ranking <= 15) {
            return 300000;
        } else if (16 <= ranking && ranking <= 21) {
            return 100000;
        } else {
            return 0;
        }
    }

    private static int get2018(int ranking) {
        if (ranking == 1) {
            return 5120000;
        } else if (2 <= ranking && ranking <= 3) {
            return 2560000;
        } else if (4 <= ranking && ranking <= 7) {
            return 1280000;
        } else if (8 <= ranking && ranking <= 15) {
            return 640000;
        } else if (16 <= ranking && ranking <= 31) {
            return 320000;
        } else {
            return 0;
        }
    }
}
