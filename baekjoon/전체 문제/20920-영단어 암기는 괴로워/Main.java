import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> words = new HashMap<>();

        while (N-- > 0) {
            String word = br.readLine();
            if (word.length() >= M) {
                words.put(word, words.getOrDefault(word, 0) + 1);
            }
        }

        ArrayList<Entry<String, Integer>> temp = new ArrayList<>(words.entrySet());
        temp.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                if (o1.getKey().length() == o2.getKey().length()) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return Integer.compare(o2.getKey().length(), o1.getKey().length());
            }
            return o2.getValue().compareTo(o1.getValue());
        });

        StringBuilder sb = new StringBuilder();
        for (Entry<String, Integer> entry : temp) {
            sb.append(entry.getKey()).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }
}
