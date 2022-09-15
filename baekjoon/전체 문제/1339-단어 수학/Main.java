import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] alphabet = new int[26];

        while (N-- > 0) {
            char[] string = br.readLine().toCharArray();
            int pow = (int) Math.pow(10, string.length - 1);

            for (char c : string) {
                alphabet[c - 65] += pow;
                pow /= 10;
            }
        }

        Arrays.sort(alphabet);

        int max = 0;

        for (int i = alphabet.length - 1, index = 9; i >= 0; i--, index--) {
            if (alphabet[i] == 0) {
                break;
            }
            max += alphabet[i] * index;
        }

        bw.write(Integer.toString(max));
        bw.flush();
    }
}
