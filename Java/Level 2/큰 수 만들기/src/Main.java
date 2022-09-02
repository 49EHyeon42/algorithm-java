public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test 1
        String number1 = "1924";
        int k1 = 2;
        String result1 = "94";

        System.out.println("test case 1 = " + (solution.solution(number1, k1).equals(result1)));

        // test 2
        String number2 = "1231234";
        int k2 = 3;
        String result2 = "3234";

        System.out.println("test case 2 = " + (solution.solution(number2, k2).equals(result2)));

        // test 3
        String number3 = "4177252841";
        int k3 = 4;
        String result3 = "775841";

        System.out.println("test case 3 = " + (solution.solution(number3, k3).equals(result3)));
    }
}
