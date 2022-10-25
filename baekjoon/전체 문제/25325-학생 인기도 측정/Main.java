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

        HashMap<String, Integer> hashMap = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            hashMap.put(st.nextToken(), 0);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                String name = st.nextToken();
                hashMap.put(name, hashMap.get(name) + 1);
            }
        }

        ArrayList<Entry<String, Integer>> arrayList = new ArrayList<>(hashMap.entrySet());
        arrayList.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue() - o1.getValue();
        });

        StringBuilder sb = new StringBuilder();
        for (Entry<String, Integer> entry : arrayList) {
            sb.append(entry.getKey()).append(' ').append(entry.getValue()).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
