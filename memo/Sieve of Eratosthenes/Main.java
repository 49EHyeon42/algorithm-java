import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

    }

    private static boolean[] sieveOfEratosthenes() {
        boolean[] primeNumbers = new boolean[10001];

        Arrays.fill(primeNumbers, true);

        primeNumbers[0] = primeNumbers[1] = false;

        for (int i = 2; i * i <= 10000; i++) {
            if (primeNumbers[i]) {
                for (int j = i * i; j <= 10000; j += i) {
                    primeNumbers[j] = false;
                }
            }
        }

        return primeNumbers;
    }
}
