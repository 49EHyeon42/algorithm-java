public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test 1
        String[] phone_book1 = {"119", "97674223", "1195524421"};
        boolean result1 = false;

        System.out.println("test case 1 = " + (solution.solution(phone_book1) == result1));

        // test 2
        String[] phone_book2 = {"123", "456", "789"};
        boolean result2 = true;

        System.out.println("test case 2 = " + (solution.solution(phone_book2) == result2));

        // test 3
        String[] phone_book3 = {"12", "123", "1235", "567", "88"};
        boolean result3 = false;

        System.out.println("test case 3 = " + (solution.solution(phone_book3) == result3));
    }
}
