import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();

        int[][] alphabetCountArray = new int[S.length()][26];
        for (int i = 0; i < S.length(); i++) {
            if (i != 0) {
                for (int alphabetIndex = 0; alphabetIndex < 26; alphabetIndex++) {
                    alphabetCountArray[i][alphabetIndex] = alphabetCountArray[i - 1][alphabetIndex];
                }
            }
            alphabetCountArray[i][S.charAt(i) - 'a']++;
        }

        int q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            char alphabet = st.nextToken().charAt(0);
            int begin = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int count = 0;
            if (begin == 0) {
                count = alphabetCountArray[end][alphabet - 'a'];
            } else {
                count = alphabetCountArray[end][alphabet - 'a']
                    - alphabetCountArray[begin - 1][alphabet - 'a'];
            }

            sb.append(count).append('\n');
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}
