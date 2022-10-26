import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<String> arrayList = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            arrayList.add(br.readLine());
        }

        arrayList.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                int o1Sum = getSum(o1);
                int o2Sum = getSum(o2);
                return (o1Sum != o2Sum) ? o1Sum - o2Sum : o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });

        StringBuilder sb = new StringBuilder();
        for (String string : arrayList) {
            sb.append(string).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    public static int getSum(String string) {
        int sum = 0;
        for (int i = 0; i < string.length(); i++) {
            if ('0' <= string.charAt(i) && string.charAt(i) <= '9') {
                sum += string.charAt(i) - '0';
            }
        }
        return sum;
    }
}
