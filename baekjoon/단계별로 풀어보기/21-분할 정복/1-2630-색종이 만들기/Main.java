import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int[][] array;
    private static int blue, white;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        array = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);

        bw.write(String.valueOf(white) + '\n' + blue);

        bw.flush();
        bw.close();
    }

    private static void partition(int row, int col, int size) {
        if (isSquare(row, col, size)) {
            if (array[row][col] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }
        int newSize = size / 2;

        partition(row, col, newSize);
        partition(row + newSize, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row + newSize, col + newSize, newSize);
    }

    private static boolean isSquare(int row, int col, int size) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (array[i][j] != array[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }
}
