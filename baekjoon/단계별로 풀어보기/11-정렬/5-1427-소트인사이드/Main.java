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

        char[] charArray = br.readLine().toCharArray();

        Arrays.sort(charArray);

        for (int i = charArray.length-1;i>=0;i--) {
            bw.write(charArray[i]);
        }

        bw.flush();
        bw.close();
    }
}
