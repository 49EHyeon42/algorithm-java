import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String title = br.readLine();
            hashMap.put(title, hashMap.getOrDefault(title, 0) + 1);
        }

        ArrayList<Entry<String, Integer>> arrayList = new ArrayList<>(hashMap.entrySet());
        arrayList.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return Integer.compare(o2.getValue(), o1.getValue());
        });

        bw.write(arrayList.get(0).getKey());

        bw.flush();
        bw.close();
    }
}
