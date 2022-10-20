import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> hashMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            hashMap.put(st.nextToken(), i);
        }

        int count = 0;

        String[] strings = br.readLine().split(" ");
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (hashMap.get(strings[i]) < hashMap.get(strings[j])) {
                    count++;
                }
            }
        }

        bw.write(count + "/" + N * (N - 1) / 2);
        bw.flush();

        br.close();
        bw.close();
    }
}
