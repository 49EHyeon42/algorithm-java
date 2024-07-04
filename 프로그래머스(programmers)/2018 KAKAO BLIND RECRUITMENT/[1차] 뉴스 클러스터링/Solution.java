import java.util.*;

class Solution {

    public int solution(String str1, String str2) {
        List<String> list1 = getList(str1.toLowerCase());
        List<String> list2 = getList(str2.toLowerCase());

        if (list1.isEmpty() && list2.isEmpty()) {
            return 65536;
        }

        int intersection = 0;

        boolean[] visited = new boolean[list2.size()];

        for (String string1 : list1) {
            for (int i = 0; i < list2.size(); i++) {
                if (visited[i] || !string1.equals(list2.get(i))) {
                    continue;
                }

                visited[i] = true;

                intersection++;

                break;
            }
        }

        int union = list1.size() + list2.size() - intersection;

        return (int) (((float) intersection / union) * 65536);
    }

    public List<String> getList(String string) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < string.length() - 1; i++) {
            char c1 = string.charAt(i);
            char c2 = string.charAt(i + 1);

            if (c1 < 'a' || c1 > 'z' || c2 < 'a' || c2 > 'z') {
                continue;
            }

            list.add(c1 + "" + c2);
        }

        return list;
    }
}
