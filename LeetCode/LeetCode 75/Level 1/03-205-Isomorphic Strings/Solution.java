class Solution {

    public boolean isIsomorphic(String s, String t) {
        return toSameStructure(s).equals(toSameStructure(t));
    }

    private List<Integer> toSameStructure(String string) {
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0, index = 0; i < string.length(); i++) {
            char character = string.charAt(i);

            if (!map.containsKey(character)) {
                map.put(character, index++);
            }

            list.add(map.get(character));
        }

        return list;
    }
}
