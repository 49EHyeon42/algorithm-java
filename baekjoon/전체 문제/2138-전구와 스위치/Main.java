import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        boolean[] from1 = new boolean[N];
        boolean[] from2 = new boolean[N];

        String string = br.readLine();

        for (int i = 0; i < N; i++) {
            from1[i] = from2[i] = string.charAt(i) == '1';
        }

        boolean[] to = new boolean[N];

        string = br.readLine();

        for (int i = 0; i < N; i++) {
            to[i] = string.charAt(i) == '1';
        }

        int result = -1;

        int count = 0;

        // 0번 스위치를 누르지 않았을 때
        for (int i = 1; i < N; i++) {
            if (from1[i - 1] != to[i - 1]) {
                pushButton(from1, i);

                count++;
            }
        }

        if (isSame(from1, to)) {
            result = count;
        }

        // 0번 스위치를 누를 때
        count = 1;

        pushButton(from2, 0);

        for (int i = 1; i < N; i++) {
            if (from2[i - 1] != to[i - 1]) {
                pushButton(from2, i);

                count++;
            }
        }

        if (isSame(from2, to)) {
            result = result == -1 ? count : Math.min(result, count);
        }

        bw.write(Integer.toString(result));
        bw.flush();

        br.close();
        bw.close();
    }

    private static void pushButton(boolean[] from, int index) {
        if (index == 0) {
            from[0] = !from[0];
            from[1] = !from[1];
        } else if (index == from.length - 1) {
            from[from.length - 2] = !from[from.length - 2];
            from[from.length - 1] = !from[from.length - 1];
        } else {
            from[index - 1] = !from[index - 1];
            from[index] = !from[index];
            from[index + 1] = !from[index + 1];
        }
    }

    private static boolean isSame(boolean[] from, boolean[] to) {
        for (int i = 0; i < from.length; i++) {
            if (from[i] != to[i]) {
                return false;
            }
        }

        return true;
    }
}
