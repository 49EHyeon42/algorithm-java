public class Hanoi {

    public static void main(String[] args) {
        // reference : https://shoark7.github.io/programming/algorithm/tower-of-hanoi
        // reference : https://brunch.co.kr/@younggiseo/139

        System.out.println("N = 1");
        hanoi(1, 1, 3, 2);

        System.out.println("N = 2");
        hanoi(2, 1, 3, 2);

        System.out.println("N = 3");
        hanoi(3, 1, 3, 2);

        System.out.println("N = 4");
        hanoi(4, 1, 3, 2);

        System.out.println("N = 5");
        hanoi(5, 1, 3, 2);
    }

    private static void hanoi(int N, int start, int to, int via) {
        if (N == 1) {
            move(1, start, to);
            return;
        }

        hanoi(N - 1, start, via, to);
        move(N, start, to);
        hanoi(N - 1, via, to, start);
    }

    private static void move(int N, int start, int to) {
        System.out.println(N + "번 원반을 " + start + "에서 " + to + "로 이동");
    }
}
