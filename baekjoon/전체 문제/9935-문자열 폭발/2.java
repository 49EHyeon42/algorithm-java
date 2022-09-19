import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// 64468KB, 528ms
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[] string = br.readLine().toCharArray();
        char[] explosionString = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();

        for (char character : string) {
            stack.push(character);

            int checkRange = stack.size() - explosionString.length;

            if (checkRange >= 0) {
                boolean canExplode = true;

                for (int i = 0; i < explosionString.length; i++) {
                    if (stack.get(checkRange + i) != explosionString[i]) {
                        canExplode = false;
                        break;
                    }
                }

                if (canExplode) {
                    for (int i = 0; i < explosionString.length; i++) {
                        stack.pop();
                    }
                }
            }
        }

        for (Character character : stack) {
            sb.append(character);
        }

        bw.write(sb.length() != 0 ? sb.toString() : "FRULA");
        bw.flush();

        br.close();
        bw.close();
    }
}
