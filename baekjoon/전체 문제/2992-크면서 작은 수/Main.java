import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static int X;
    private static char[] chars;
    private static boolean[] visited;
    private static char[] buffer;

    private static int min = Integer.MAX_VALUE;

    // 순열
    private static void backtracking(int depth) {
        if (buffer.length == depth) {
            int value = Integer.parseInt(new String(buffer));
            if (value > X && value < min) {
                min = value;
            }
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            buffer[depth] = chars[i];
            backtracking(depth + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String stringX = br.readLine();
        X = Integer.parseInt(stringX);
        chars = stringX.toCharArray();
        visited = new boolean[chars.length];
        buffer = new char[chars.length];

        backtracking(0);

        if (min == Integer.MAX_VALUE) {
            min = 0;
        }

        bw.write(Integer.toString(min));
        bw.flush();

        br.close();
        bw.close();
    }
}
