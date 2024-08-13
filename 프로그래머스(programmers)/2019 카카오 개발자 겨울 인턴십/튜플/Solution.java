import java.util.*;

class Solution {

    public int[] solution(String s) {
        StringBuilder sb = new StringBuilder();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '{' || c == '}') {
                continue;
            }

            while (i < s.length() && s.charAt(i) != ',' && s.charAt(i) != '}') {
                sb.append(s.charAt(i++));
            }

            if (sb.toString().isEmpty()) {
                continue;
            }

            int number = Integer.parseInt(sb.toString());

            sb.setLength(0);

            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        List<Node> list = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new Node(entry.getKey(), entry.getValue()));
        }

        list.sort((node1, node2) -> node2.count - node1.count);

        return list.stream()
                .mapToInt(node -> node.number)
                .toArray();
    }

    private static class Node {

        final int number;
        final int count;

        Node(int number, int count) {
            this.number = number;
            this.count = count;
        }
    }
}
