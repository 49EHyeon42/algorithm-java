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
        int C = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        HashMap<Integer, Integer> firstIndexHashMap = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            hashMap.put(number, hashMap.getOrDefault(number, 0) + 1);
            if (!firstIndexHashMap.containsKey(number)) {
                firstIndexHashMap.put(number, i);
            }
        }

        ArrayList<Entry<Integer, Integer>> list = new ArrayList<>(hashMap.entrySet());

        list.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return Integer.compare(firstIndexHashMap.get(o1.getKey()),
                    firstIndexHashMap.get(o2.getKey()));
            }
            return Integer.compare(o2.getValue(), o1.getValue());
        });

        StringBuilder sb = new StringBuilder();
        for (Entry<Integer, Integer> entry : list) {
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey()).append(' ');
            }
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }
}
