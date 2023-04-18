import java.util.ArrayList;
import java.util.Comparator;

public class Solution {

    public String[] solution(String[][] tickets) {
        ArrayList<String> list = new ArrayList<>();
        boolean[] isVisited = new boolean[tickets.length];

        backtracking(tickets, list, isVisited, "ICN", "ICN", 0);

        list.sort(Comparator.naturalOrder());

        return list.get(0).split(" ");
    }

    private void backtracking(String[][] tickets, ArrayList<String> list, boolean[] isVisited,
        String current, String next, int depth) {
        if (tickets.length == depth) {
            list.add(next);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!isVisited[i] && current.equals(tickets[i][0])) {
                isVisited[i] = true;
                backtracking(tickets, list, isVisited, tickets[i][1], next + " " + tickets[i][1],
                    depth + 1);
                isVisited[i] = false;
            }
        }
    }
}
