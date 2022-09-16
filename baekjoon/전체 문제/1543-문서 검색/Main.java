import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String document = br.readLine();
        String word = br.readLine();

        bw.write(Integer.toString(solution(document, word)));
        bw.flush();
        
        br.close();
        bw.close();
    }

    private static int solution(String document, String word) {
        int count = 0;

        if (document.length() < word.length()) {
            return count;
        }

        for (int i = 0; i <= document.length() - word.length(); i++) {
            if (document.startsWith(word, i)) {
                count++;
                i += word.length() - 1;
            }
        }

        return count;
    }
}
