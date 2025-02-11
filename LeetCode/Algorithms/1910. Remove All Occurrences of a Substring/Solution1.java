class Solution1 {

    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));

            if (sb.length() < part.length()) {
                continue;
            }

            if (equals(sb, part)) {
                for (int j = 0; j < part.length(); j++) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }

        return sb.toString();
    }

    private boolean equals(StringBuilder sb, String part) {
        for (int i = sb.length() - part.length(), j = 0; i < sb.length(); i++, j++) {
            if (sb.charAt(i) != part.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}