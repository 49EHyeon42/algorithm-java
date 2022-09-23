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

        HashMap<Long, Integer> hashMap = new HashMap<>();

        while (N-- > 0) {
            long number = Long.parseLong(br.readLine());

            hashMap.put(number, hashMap.getOrDefault(number, 0) + 1);
        }

        int maxCount = 0;

        for (Integer value : hashMap.values()) {
            if (maxCount < value) {
                maxCount = value;
            }
        }

        long minNumber = Long.MAX_VALUE;

        for (Long number : hashMap.keySet()) {
            if (minNumber > number && hashMap.get(number) == maxCount) {
                minNumber = number;
            }
        }

        bw.write(Long.toString(minNumber));
        bw.flush();

        br.close();
        bw.close();
    }
}
