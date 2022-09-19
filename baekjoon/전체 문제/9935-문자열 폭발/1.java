import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;

// 154672KB, 712ms : 무거움
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[] string = br.readLine().toCharArray();
        char[] explosionString = br.readLine().toCharArray();

        // stack 비교용 리스트
        ArrayList<Character> explosionStringList = new ArrayList<>();
        for (char character : explosionString) {
            explosionStringList.add(character);
        }

        Stack<Character> stack = new Stack<>();

        for (char character : string) {
            stack.push(character);

            int checkRange = stack.size() - explosionString.length;

            if (checkRange >= 0) {
                boolean canExplode = stack.subList(checkRange, stack.size())
                    .equals(explosionStringList);

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
