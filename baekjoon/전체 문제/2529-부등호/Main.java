import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    private static int K;

    private static char[] array;

    private static final ArrayList<String> temp = new ArrayList<>();
    private static final boolean[] isVisited = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(br.readLine());

        array = new char[K];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            array[i] = st.nextToken().charAt(0);
        }

        backtracking(0, "");

        temp.sort(Comparator.naturalOrder());

        bw.write(temp.get(temp.size() - 1) + "\n" + temp.get(0));
        bw.flush();

        br.close();
        bw.close();
    }

    private static void backtracking(int depth, String number) {
        if (depth == K + 1) {
            temp.add(number);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (depth == 0 || (!isVisited[i] && isPossible(number.charAt(depth - 1),
                (char) (i + '0'), array[depth - 1]))) {
                isVisited[i] = true;
                backtracking(depth + 1, number + i);
                isVisited[i] = false;
            }
        }
    }

    private static boolean isPossible(char i, char j, char sign) {
        return (sign == '<') ? i < j : i > j;
    }
}
