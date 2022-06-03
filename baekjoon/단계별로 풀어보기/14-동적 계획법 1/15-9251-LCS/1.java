import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] string1 = br.readLine().toCharArray();
        char[] string2 = br.readLine().toCharArray();

        int[][] dpArray = new int[string1.length + 1][string2.length + 1];

        for (int i = 1; i <= string1.length; i++) {
            for (int j = 1; j <= string2.length; j++) {
                dpArray[i][j] = (string1[i - 1] == string2[j - 1]) ?
                    dpArray[i - 1][j - 1] + 1 : Math.max(dpArray[i - 1][j], dpArray[i][j - 1]);
            }
        }

        bw.write(Integer.toString(dpArray[string1.length][string2.length]));

        bw.flush();
        bw.close();
    }
}
