import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String inputWord = br.readLine();

        List<String> words = new ArrayList<>();

        for (int i = 1; i < inputWord.length() - 1; i++) {
            for (int j = i + 1; j < inputWord.length(); j++) {
                String first = new StringBuffer(inputWord.substring(0, i)).reverse().toString();
                String second = new StringBuffer(inputWord.substring(i, j)).reverse().toString();
                String third = new StringBuffer(inputWord.substring(j)).reverse().toString();
                words.add(first + second + third);
            }
        }

        words.sort(String::compareTo);

        bw.write(words.get(0));
        bw.flush();

        br.close();
        bw.close();
    }
}
