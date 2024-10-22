import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        for (int i = N; i >= 0; i--) {
            sb.append(i).append(' ');
        }

        System.out.print(sb.toString().trim());
    }
}
