import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// reference : https://measurezero.tistory.com/936 && 백준
public class Main {

    private static final int VERTEX_NUMBER = 8;

    private static int answer;
    private static int[] array;
    private static boolean[] isVisited;
    private static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        array = new int[VERTEX_NUMBER];
        isVisited = new boolean[VERTEX_NUMBER];
        list = new int[VERTEX_NUMBER];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < VERTEX_NUMBER; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        list[0] = array[0];

        recursive(0);

        bw.write(Integer.toString(answer));

        bw.flush();
        bw.close();
    }

    // refactoring
    private static void recursive(int count) {
        if (count == 8 && isPossible()) {
            answer++;
            return;
        }

        for (int i = 0; i < VERTEX_NUMBER; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                list[count] = array[i];
                recursive(count + 1);
                isVisited[i] = false;
            }
        }
    }

    // refactoring
    private static boolean isPossible() {
        for (int i = 0; i < 8; i++) {
            int p1 = list[i];
            int p2 = list[(i + 1) % 8];
            int p3 = list[(i + 2) % 8];

            if (!isSharp(p1, p2, p3)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isSharp(int p1, int p2, int p3) {
        return Math.pow(p1 + p3, 2) * Math.pow(p2, 2) >= Math.pow(p1, 2) * Math.pow(p3, 2) * 2;
    }
}
