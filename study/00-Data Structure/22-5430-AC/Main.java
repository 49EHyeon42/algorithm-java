import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            LinkedList<Integer> linkedList = new LinkedList<>();

            String command = br.readLine();

            int arraySize = Integer.parseInt(br.readLine());

            String arrayOfString = br.readLine();

            arrayOfString = arrayOfString.substring(1, arrayOfString.length() - 1);

            StringTokenizer st = new StringTokenizer(arrayOfString, ",");
            for (int j = 0; j < arraySize; j++) {
                linkedList.addLast(Integer.parseInt(st.nextToken()));
            }

            boolean flagLeftToRight = true; // 왼쪽에서 오른쪽으로
            boolean flagError = false;
            for (int j = 0; j < command.length(); j++) {
                if (command.charAt(j) == 'R') {
                    flagLeftToRight = !flagLeftToRight;
                } else {
                    if (linkedList.isEmpty()) {
                        flagError = true;
                        break;
                    }

                    if (flagLeftToRight) {
                        linkedList.pollFirst();
                    } else {
                        linkedList.pollLast();
                    }
                }
            }

            if (flagError) {
                sb.append("error\n");
            } else {
                sb.append('[');
                if (!linkedList.isEmpty()) {
                    if (flagLeftToRight) {
                        sb.append(linkedList.pollFirst());
                    } else {
                        sb.append(linkedList.pollLast());
                    }
                }
                while (!linkedList.isEmpty()) {
                    if (flagLeftToRight) {
                        sb.append(',').append(linkedList.pollFirst());
                    } else {
                        sb.append(',').append(linkedList.pollLast());
                    }
                }
                sb.append("]\n");
            }
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}
