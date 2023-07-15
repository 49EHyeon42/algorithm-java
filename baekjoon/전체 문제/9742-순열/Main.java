import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static String string;
    private static int target;

    private static boolean[] visited;
    private static char[] chars;

    private static int count;
    private static String result;

    // 순열
    private static void backtracking(int depth) {
        if (result != null) {
            return;
        }

        if (depth == string.length()) {
            count++;

            if (count == target) {
                result = new String(chars);
            }

            return;
        }

        for (int i = 0; i < string.length(); i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            chars[depth] = string.charAt(i);
            backtracking(depth + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String line;

        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            string = st.nextToken();
            target = Integer.parseInt(st.nextToken());

            visited = new boolean[string.length()];
            chars = new char[string.length()];

            count = 0;
            result = null;

            backtracking(0);

            if (result == null) {
                result = "No permutation";
            }

            sb.append(string).append(' ').append(target).append(" = ").append(result).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }
}
