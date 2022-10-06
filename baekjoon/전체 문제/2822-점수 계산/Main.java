import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer[] array = new Integer[8];
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < 8; i++) {
            int score = Integer.parseInt(br.readLine());

            array[i] = score;
            hashMap.put(score, i + 1);
        }

        Arrays.sort(array, Collections.reverseOrder());

        int sum = 0;
        int[] temp = new int[5];

        for (int i = 0; i < 5; i++) {
            sum += array[i];
            temp[i] = hashMap.get(array[i]);
        }

        Arrays.sort(temp);

        StringBuilder sb = new StringBuilder();
        sb.append(sum).append('\n');
        for (int i : temp) {
            sb.append(i).append(' ');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }
}
