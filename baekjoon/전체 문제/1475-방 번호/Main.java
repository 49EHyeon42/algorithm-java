import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String string = br.readLine();

        int[] array = new int[10];

        for (int i = 0; i < string.length(); i++) {
            array[Character.getNumericValue(string.charAt(i))]++;
        }

        int max = 0;

        for (int i = 0; i < 10; i++) {
            int currentMax = i == 6 || i == 9 ? (array[6] + array[9] + 1) / 2 : array[i];

            if (max < currentMax) {
                max = currentMax;
            }
        }

        bw.write(Integer.toString(max));
        bw.flush();

        br.close();
        bw.close();
    }
}
