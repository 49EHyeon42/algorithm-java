import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[][] array = new boolean[100][100];

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    array[y + i][x + j] = true;
                }
            }
        }

        int count = 0;

        for (boolean[] booleans : array) {
            for (boolean b : booleans) {
                if (b) {
                    count++;
                }
            }
        }

        bw.write(Integer.toString(count));
        bw.flush();

        br.close();
        bw.close();
    }
}
