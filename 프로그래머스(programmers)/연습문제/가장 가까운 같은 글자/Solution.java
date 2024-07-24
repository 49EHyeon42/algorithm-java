class Solution {

    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        int[] alphabet = new int[26];

        for (int i = 0; i < 26; i++) {
            alphabet[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            answer[i] = alphabet[s.charAt(i) - 'a'] == -1 ? -1 : i - alphabet[s.charAt(i) - 'a'];

            alphabet[s.charAt(i) - 'a'] = i;
        }

        return answer;
    }
}
