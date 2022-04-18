import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] originalArray = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            originalArray[i] = Integer.parseInt(st.nextToken());
        }

        int[] copyArray = originalArray.clone();

        Arrays.sort(copyArray);

        HashMap<Integer, Integer> tempMap = new HashMap<Integer, Integer>();

        int count = 0;
        for (int value : copyArray) {
            if (!tempMap.containsKey(value)) {
                tempMap.put(value, count);
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int value : originalArray) {
            sb.append(tempMap.get(value)).append(' ');
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}
