// reference : https://ip99202.github.io/posts/%EC%9C%A0%EB%8B%88%EC%98%A8-%ED%8C%8C%EC%9D%B8%EB%93%9C(Union-Find)/#:~:text=%EC%9C%A0%EB%8B%88%EC%98%A8%20%ED%8C%8C%EC%9D%B8%EB%93%9C%EB%8A%94%20%EA%B7%B8%EB%9E%98%ED%94%84%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98,%EC%B0%BE%EB%8A%94%20Find%EC%97%B0%EC%82%B0%EC%9C%BC%EB%A1%9C%20%EC%9D%B4%EB%A3%A8%EC%96%B4%EC%A7%84%EB%8B%A4.
public class Main {

    private static final int[] parent = new int[9];

    public static void main(String[] args) {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        merge(1, 2);
        merge(4, 5);
        merge(5, 6);
        System.out.println("2와 4는 같은 집합인가?\n" + isUnion(2, 4));
        merge(1, 5);
        System.out.println("1와 6는 같은 집합인가?\n" + isUnion(1, 6));
    }

    private static int find(int index) {
        return (parent[index] == index) ? index : (parent[index] = find(parent[index]));
    }

    private static void merge(int x, int y) {
        int tempX = find(x);
        int tempY = find(y);
        if (tempX != tempY) {
            parent[tempY] = tempX;
        }
    }

    private static boolean isUnion(int x, int y) {
        return find(x) == find(y);
    }
}
