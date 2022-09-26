public class Main {

    public static void main(String[] args) {
        int a = 8;
        int b = 123;

        System.out.println("예제");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println();

        System.out.println("2진수 출력");
        System.out.println("a = " + Integer.toBinaryString(a));
        System.out.println("b = " + Integer.toBinaryString(b));
        System.out.println();

        System.out.println("a AND b");
        System.out.println("a&b = " + Integer.toBinaryString(a & b));
        System.out.println();

        System.out.println("a OR b");
        System.out.println("a|b = " + Integer.toBinaryString(a | b));
        System.out.println();

        System.out.println("a XOR b");
        System.out.println("a^b = " + Integer.toBinaryString(a ^ b));
        System.out.println();

        System.out.println("NOT a, b");
        System.out.println("~a = " + Integer.toBinaryString(~a));
        System.out.println("~b = " + Integer.toBinaryString(~b));
        System.out.println();

        /*
         * 비트 연산자
         *
         * a는 정수, i는 자연수라고 가정
         *
         * << a를 왼쪽으로 i bit 만큼 이동 (빈자리는 0, MSB가 1이면 음수 변경)
         * >> a를 오른쪽으로 i bit 만큼 이동 (빈자리는 a의 MSB와 같은 값으로 변경)
         * >>> a를 오른쪽으로 i bit 만큼 이동 (빈자리는 0)
         * */

        /*
         * 비트마스크(bitmask)
         * 1. 빠름
         * 2. 간결함
         * 3. 적은 비용
         *
         * 부분 집합 구현 가능
         * */

        /*
         * 부분 힙합
         *
         * int[] arr = new int[]{1,2,3};
         *
         * int n = arr.length;
         *
         * System.out.println(1 << n); 최대 개수
         *
         * for(int i = 0; i < (1<<n); i++) {
         *     for(int j = 0; j < n; j++) {
         *         if((i & (1<<j)) != 0) {
         *             System.out.print(arr[j] + ", "); 부분 집합 출력
         *         }
         *     }
         *     System.out.println();
         * }
         * */
    }
}
