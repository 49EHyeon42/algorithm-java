import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {

    private static int n;
    private static int k;

    private static int[] array;
    private static boolean[] isVisited;

    private static final HashSet<Integer> hashSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        array = new int[n];
        isVisited = new boolean[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        backtracking(0, "");

        bw.write(Integer.toString(hashSet.size()));
        bw.flush();

        br.close();
        bw.close();
    }

    private static void backtracking(int depth, String number) {
        if (k == depth) {
            hashSet.add(Integer.parseInt(number));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                backtracking(depth + 1, number + array[i]);
                isVisited[i] = false;
            }
        }
    }
}
