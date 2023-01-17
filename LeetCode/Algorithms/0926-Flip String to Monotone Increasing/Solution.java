class Solution {

    public int minFlipsMonoIncr(String s) {
        int minFlip = 0;
        int numberOfOne = 0;

        for (char c : s.toCharArray()) {
            if (c == '0') {
                minFlip = Math.min(++minFlip, numberOfOne);
            } else {
                numberOfOne++;
            }
        }

        return minFlip;
    }
}
