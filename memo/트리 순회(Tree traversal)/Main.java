public class Main {

    public static void main(String[] args) {
        // reference : https://www.baeldung.com/java-binary-tree

        BinaryTree binaryTree = new BinaryTree();

        binaryTree.add(6);
        binaryTree.add(2);
        binaryTree.add(8);
        binaryTree.add(0);
        binaryTree.add(4);
        binaryTree.add(3);
        binaryTree.add(5);
        binaryTree.add(7);
        binaryTree.add(9);

        System.out.println("중위 순회");
        binaryTree.traverseInOrder(binaryTree.root);

        System.out.println("\n전위 순회");
        binaryTree.traversePreOrder(binaryTree.root);

        System.out.println("\n후위 순회");
        binaryTree.traversePostOrder(binaryTree.root);

        System.out.println("\n층별 순회");
        binaryTree.traverseLevelOrder();
    }
}
