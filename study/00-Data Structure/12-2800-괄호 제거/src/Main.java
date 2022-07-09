import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeSet;

// reference : https://velog.io/@pss407/%EB%B0%B1%EC%A4%802800-%EA%B4%84%ED%98%B8-%EC%A0%9C%EA%B1%B0
public class Main {

    private static ArrayList<Bracket> bracketArrayList = new ArrayList<>();
    private static TreeSet<String> answerTreeSet = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String string = br.readLine();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                bracketArrayList.add(new Bracket(stack.pop(), i));
            }
        }

        dfs(string, 0);

        StringBuilder sb = new StringBuilder();
        for (String answer : answerTreeSet) {
            sb.append(answer).append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    private static void dfs(String string, int index) {
        if (index >= bracketArrayList.size()) {
            return;
        }

        for (int i = index; i < bracketArrayList.size(); i++) {
            Bracket bracket = bracketArrayList.get(i);

            StringBuilder sb = new StringBuilder(string);
            sb.replace(bracket.openIndex, bracket.openIndex + 1, " ");
            sb.replace(bracket.closeIndex, bracket.closeIndex + 1, " ");

            answerTreeSet.add(sb.toString().replaceAll(" ", ""));
            dfs(sb.toString(), i + 1);

            sb.replace(bracket.openIndex, bracket.openIndex + 1, "(");
            sb.replace(bracket.closeIndex, bracket.closeIndex + 1, ")");
        }
    }

    private static class Bracket {

        int openIndex;
        int closeIndex;

        public Bracket(int openIndex, int closeIndex) {
            this.openIndex = openIndex;
            this.closeIndex = closeIndex;
        }
    }
}
