class Solution {

    public boolean isIsomorphic(String s, String t) {
        return toSameStructure(s).equals(toSameStructure(t));
    }

    private String toSameStructure(String string) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);

            if (!map.containsKey(character)) {
                map.put(character, i);
            }
            
            sb.append(map.get(character)).append(' ');
        }

        return sb.toString().trim();
    }
}
