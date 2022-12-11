class Solution {

    public boolean isPalindrome(int x) {
        String string = Integer.toString(x);

        for (int i = 0, j = string.length() - 1; i < j; i++, j--) {
            if (string.charAt(i) != string.charAt(j)) {
                return false;
            }
        }
        return true;
    }

        public boolean isPalindrome2(int x) {
        int original = x;
        int rev = 0;

        while (x > 0) {
            rev = x % 10 + rev * 10;
            x = x / 10;
        }

        return rev == original;
    }

    public boolean isPalindrome3(int x) {
        //optimizations
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        if (x % 10 == 0) {
            return false;
        }
        if (x < 100 && x % 11 == 0) {
            return true;
        }
        if (x < 1000 && ((x / 100) * 10 + x % 10) % 11 == 0) {
            return true;
        }

        //actual logic
        int v = x % 10;
        x = x / 10;

        while (x - v > 0) {
            v = v * 10 + x % 10;
            x /= 10;
        }

        if (v > x) {
            v /= 10;
        }

        return v == x;
    }
}
