import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

// 169784 KB, 1088 MS
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int key = Integer.parseInt(st.nextToken());
            if (hashMap.containsKey(key)) {
                hashMap.replace(key, hashMap.get(key) + 1);
            } else {
                hashMap.put(key, 1);
            }
        }

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int targetKey = Integer.parseInt(st.nextToken());

            int count = 0;
            if (hashMap.containsKey(targetKey)) {
                count = hashMap.get(targetKey);
            }

            sb.append(count).append(' ');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}
