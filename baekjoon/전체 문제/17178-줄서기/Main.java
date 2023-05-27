import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static String solution(int N, Ticket[] tickets, Ticket[] sequence) {
        Stack<Ticket> stack = new Stack<>();

        int i = 0;
        int j = 0;
        while (i < N * 5 && j < N * 5) {
            if (tickets[i].equals(sequence[j])) {
                i++;
                j++;
            } else if (!stack.isEmpty() && stack.peek().equals(sequence[j])) {
                stack.pop();
                j++;
            } else {
                stack.push(tickets[i++]);
            }
        }

        while (!stack.isEmpty()) {
            if (!stack.peek().equals(sequence[j++])) {
                return "BAD";
            }
            stack.pop();
        }

        return "GOOD";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Ticket[] tickets = new Ticket[N * 5];
        Ticket[] sequence = new Ticket[N * 5];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                String ticket = st.nextToken();
                tickets[i * 5 + j] = sequence[i * 5 + j] = new Ticket(ticket);
            }
        }

        Arrays.sort(sequence, (o1, o2) -> o1.alphabet == o2.alphabet ?
                o1.number - o2.number : o1.alphabet - o2.alphabet);

        bw.write(solution(N, tickets, sequence));
        bw.flush();

        br.close();
        bw.close();
    }

    private static class Ticket {

        private final char alphabet;
        private final int number;

        public Ticket(String ticket) {
            String[] split = ticket.split("-");
            this.alphabet = split[0].charAt(0);
            this.number = Integer.parseInt(split[1]);
        }
    }
}
