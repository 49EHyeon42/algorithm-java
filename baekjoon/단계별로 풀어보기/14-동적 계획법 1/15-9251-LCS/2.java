import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static char[] string1;
    private static char[] string2;
    private static int[][] dpArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        string1 = br.readLine().toCharArray();
        string2 = br.readLine().toCharArray();

        dpArray = new int[string1.length + 1][string2.length + 1];

        bw.write(Integer.toString(LCS(string1.length - 1, string2.length - 1)));

        bw.flush();
        bw.close();
    }

    private static int LCS(int index1, int index2) {
        if (index1 == -1 || index2 == -1) {
            return 0;
        }

        if (dpArray[index1][index2] == 0) {
            dpArray[index1][index2] = ((string1[index1] == string2[index2])) ?
                LCS(index1 - 1, index2 - 1) + 1 :
                Math.max(LCS(index1 - 1, index2), LCS(index1, index2 - 1));
        }

        return dpArray[index1][index2];
    }
}
