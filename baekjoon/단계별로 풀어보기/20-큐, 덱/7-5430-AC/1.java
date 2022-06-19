import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 시간 초과
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

            boolean flag = false;
            for (int j = 0; j < command.length(); j++) {
                if (command.charAt(j) == 'R') {
                    Collections.reverse(linkedList);
                } else {
                    if (linkedList.isEmpty()) {
                        flag = true;
                        break;
                    }
                    linkedList.pollFirst();
                }
            }

            if (flag) {
                sb.append("error\n");
            } else {
                sb.append('[');
                if (!linkedList.isEmpty()) {
                    sb.append(linkedList.pollFirst());
                }
                while (!linkedList.isEmpty()) {
                    sb.append(',').append(linkedList.pollFirst());
                }
                sb.append("]\n");
            }
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}
