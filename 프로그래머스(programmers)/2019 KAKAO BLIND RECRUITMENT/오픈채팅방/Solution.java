import java.util.*;

class Solution {

    private final Map<String, String> map = new HashMap<>();
    private final List<Node> list = new ArrayList<>();


    public String[] solution(String[] record) {
        for (String string : record) {
            StringTokenizer st = new StringTokenizer(string);

            String command = st.nextToken();
            String userId = st.nextToken();

            if (command.equals("Enter")) {
                map.put(userId, st.nextToken());
                list.add(new Node(userId, false));
            } else if (command.equals("Leave")) {
                list.add(new Node(userId, true));
            } else { // command.equals("Change")
                map.put(userId, st.nextToken());
            }
        }

        List<String> answer = new ArrayList<>();

        for (Node node : list) {
            answer.add(map.get(node.userId) + (node.isExit ? "님이 나갔습니다." : "님이 들어왔습니다."));
        }

        return answer.toArray(String[]::new);
    }

    private static class Node {

        final String userId;
        final boolean isExit;

        Node(String userId, boolean isExit) {
            this.userId = userId;
            this.isExit = isExit;
        }
    }
}
