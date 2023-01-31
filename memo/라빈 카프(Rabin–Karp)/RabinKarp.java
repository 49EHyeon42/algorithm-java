class RabinKarp {

    private static final int EXPONENT = 2;

    private int getCount(String string, String pattern) {
        int count = 0;

        int stringLength = string.length();
        int patternLength = pattern.length();

        int stringHash = 0;
        int patternHash = 0;

        int power = 1;

        for (int i = 0; i <= stringLength - patternLength; i++) {
            if (i == 0) {
                for (int j = 0; j < patternLength; j++) {
                    stringHash += string.charAt(patternLength - 1 - j) * power;
                    patternHash += pattern.charAt(patternLength - 1 - j) * power;

                    if (j < patternLength - 1) {
                        power *= EXPONENT;
                    }
                }
            } else {
                stringHash = EXPONENT * (stringHash - string.charAt(i - 1) * power)
                        + string.charAt(patternLength - 1 + i);
            }

            if (stringHash == patternHash) {
                boolean isFind = true;

                for (int j = 0; j < patternLength; j++) {
                    if (string.charAt(i + j) != pattern.charAt(j)) {
                        isFind = false;
                        break;
                    }
                }

                if (isFind) {
                    count++;
                }
            }
        }

        return count;
    }
}
