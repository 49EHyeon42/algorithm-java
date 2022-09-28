import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int L;
    private static int C;

    private static char[] array;
    private static boolean[] isVisited;

    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        array = new char[C];
        isVisited = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            array[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(array);

        backtracking(0, 0);

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void backtracking(int depth, int start) {
        if (L == depth) {
            int vowelCount = 0;
            int consonantCount = 0;

            StringBuilder tempSb = new StringBuilder();

            for (int i = 0; i < C; i++) {
                if (isVisited[i]) {
                    tempSb.append(array[i]);

                    if (isVowel(array[i])) {
                        vowelCount++;
                    } else {
                        consonantCount++;
                    }
                }
            }

            if (vowelCount > 0 && consonantCount > 1) {
                sb.append(tempSb).append('\n');
            }
        }

        for (int i = start; i < C; i++) {
            isVisited[i] = true;
            backtracking(depth + 1, i + 1);
            isVisited[i] = false;
        }
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
