import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
         * N = 텍스트의 길이
         * M = 패턴의 길이
         *
         * 브루트 포스의 시간 복잡도 = O(N*M)
         * search 알고리즘의 시간 복잡도 = O(N+M)
         * */

        Scanner sc = new Scanner(System.in);
        System.out.print("input text : ");
        String text = sc.next();
        System.out.print("input pattern : ");
        String pattern = sc.next();
        System.out.println();

        System.out.println("text = " + text);
        System.out.println("pattern = " + pattern);
        System.out.println();

        BruteForce bf = new BruteForce();
        ArrayList<Integer> bfList = bf.search(text, pattern);

        System.out.println("브루트 포스 탐색 결과");
        if (bfList.isEmpty()) {
            System.out.println("없음");
        } else {
            for (Integer index : bfList) {
                System.out.print("index = " + index + " ");
            }
            System.out.println();
        }

        Kmp kmp = new Kmp();
        ArrayList<Integer> kmpList = kmp.search(text, pattern);

        System.out.println("KMP 탐색 결과");
        if (kmpList.isEmpty()) {
            System.out.println("없음");
        } else {
            for (Integer index : kmpList) {
                System.out.print("index = " + index + " ");
            }
            System.out.println();
        }
    }
}
