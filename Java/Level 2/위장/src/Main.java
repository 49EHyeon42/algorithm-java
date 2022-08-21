public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test 1
        String[][] clothes1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"},
            {"green_turban", "headgear"}};
        int result1 = 5;

        System.out.println("test case 1 = " + (solution.solution(clothes1) == result1));

        // test 2
        String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"},
            {"smoky_makeup", "face"}};
        int result2 = 3;

        System.out.println("test case 2 = " + (solution.solution(clothes2) == result2));
    }
}
