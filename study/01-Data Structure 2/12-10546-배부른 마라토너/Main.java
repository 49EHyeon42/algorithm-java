import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            hashMap.put(name, hashMap.getOrDefault(name, 0) + 1);
        }

        for (int i = 0; i < N - 1; i++) {
            String name = br.readLine();
            hashMap.put(name, hashMap.getOrDefault(name, 0) - 1);
        }

        for (String name : hashMap.keySet()) {
            if (hashMap.get(name) != 0) {
                bw.write(name);
                break;
            }
        }

        bw.flush();
        bw.close();
    }
}
