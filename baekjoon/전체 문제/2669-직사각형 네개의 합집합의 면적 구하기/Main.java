import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[][] array = new boolean[100][100];

        int N = 4;

        int count = 0;

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int leftX = Integer.parseInt(st.nextToken()) - 1;
            int leftY = Integer.parseInt(st.nextToken()) - 1;
            int rightX = Integer.parseInt(st.nextToken()) - 1;
            int rightY = Integer.parseInt(st.nextToken()) - 1;

            for (int i = leftY; i < rightY; i++) {
                for (int j = leftX; j < rightX; j++) {
                    if (array[i][j]) {
                        continue;
                    }

                    array[i][j] = true;

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
