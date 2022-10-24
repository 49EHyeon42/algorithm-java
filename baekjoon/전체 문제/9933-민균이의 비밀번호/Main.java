import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        HashSet<String> hashSet = new HashSet<>();

        while (N-- > 0) {
            String word = br.readLine();
            String reverseWord = new StringBuilder(word).reverse().toString();

            if (word.equals(reverseWord) || hashSet.contains(reverseWord)) {
                bw.write(word.length() + " " + word.charAt(word.length() / 2));
            } else {
                hashSet.add(word);
            }
        }

        bw.flush();

        br.close();
        bw.close();
    }
}
