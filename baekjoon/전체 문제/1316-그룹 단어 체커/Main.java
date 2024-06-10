import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int count = 0;

        while (N-- > 0) {
            boolean flag = true;

            boolean[] alphabet = new boolean[26];

            String string = br.readLine();

            for (int i = 1; i < string.length(); i++) {
                if (string.charAt(i - 1) == string.charAt(i)) {
                    continue;
                }

                if (alphabet[string.charAt(i - 1) - 97]) {
                    flag = false;
                    break;
                }

                alphabet[string.charAt(i - 1) - 97] = true;
            }

            // 마지막 문자도 확인
            if (!alphabet[string.charAt(string.length()-1) - 97] && flag) {
                count++;
            }
        }

        bw.write(Integer.toString(count));
        bw.flush();

        br.close();
        bw.close();
    }
}
