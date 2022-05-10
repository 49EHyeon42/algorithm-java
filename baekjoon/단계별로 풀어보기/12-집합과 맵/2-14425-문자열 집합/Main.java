import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> hashSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            hashSet.add(br.readLine());
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            if (hashSet.contains(br.readLine())) {
                ++count;
            }
        }

        bw.write(Integer.toString(count));

        bw.flush();
        bw.close();
    }
}
