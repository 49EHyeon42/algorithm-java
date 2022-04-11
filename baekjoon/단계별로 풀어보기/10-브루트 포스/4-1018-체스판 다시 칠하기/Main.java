import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static private char[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        array = new char[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                array[i][j] = input.charAt(j);
            }
        }

        int answer = 64;
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                answer = Math.min(answer, GetMinChangeNum(i, j));
            }
        }

        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
    }

    public static int GetMinChangeNum(int y, int x) {
        int count = 0;

        char tempChar = array[y][x];
        for (int i = y; i < y + 8; i++) {
            for (int j = x; j < x + 8; j++) {
                if (array[i][j] != tempChar) {
                    count++;
                }

                tempChar = tempChar == 'B' ? 'W' : 'B';
            }

            tempChar = tempChar == 'B' ? 'W' : 'B';
        }

        return Math.min(count, 64 - count);
    }
}
