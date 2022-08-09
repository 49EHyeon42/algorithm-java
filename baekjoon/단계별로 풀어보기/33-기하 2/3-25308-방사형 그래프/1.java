import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// reference : https://measurezero.tistory.com/936
public class Main {

    private static final int VERTEX_NUMBER = 8;

    private static int answer;
    private static int[] array;
    private static boolean[] isVisited;
    private static final List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        array = new int[VERTEX_NUMBER];
        isVisited = new boolean[VERTEX_NUMBER];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < VERTEX_NUMBER; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        recursive(0);

        bw.write(Integer.toString(answer));

        bw.flush();
        bw.close();
    }

    private static void recursive(int count) {
        if (count == 8 && isPossible()) {
            answer++;
            return;
        }

        for (int i = 0; i < VERTEX_NUMBER; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                list.add(array[i]);
                recursive(count + 1);
                list.remove(list.size() - 1);
                isVisited[i] = false;
            }
        }
    }

    private static boolean isPossible() {
        return isSharp(list.get(0), list.get(1), list.get(2)) &&
            isSharp(list.get(1), list.get(2), list.get(3)) &&
            isSharp(list.get(2), list.get(3), list.get(4)) &&
            isSharp(list.get(3), list.get(4), list.get(5)) &&
            isSharp(list.get(4), list.get(5), list.get(6)) &&
            isSharp(list.get(5), list.get(6), list.get(7)) &&
            isSharp(list.get(6), list.get(7), list.get(0)) &&
            isSharp(list.get(7), list.get(0), list.get(1));
    }

    private static boolean isSharp(int p1, int p2, int p3) {
        return Math.pow(p1 + p3, 2) * Math.pow(p2, 2) >= Math.pow(p1, 2) * Math.pow(p3, 2) * 2;
    }
}
