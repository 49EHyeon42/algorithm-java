import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> hashMap = new HashMap<>();
        TreeSet<String> treeSet = new TreeSet<>();

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ".");
            String fileName = st.nextToken();
            String extension = st.nextToken();

            hashMap.put(extension, hashMap.getOrDefault(extension, 0) + 1);
            treeSet.add(extension);
        }

        StringBuilder sb = new StringBuilder();
        for (String extension : treeSet) {
            sb.append(extension).append(' ').append(hashMap.get(extension)).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }
}
