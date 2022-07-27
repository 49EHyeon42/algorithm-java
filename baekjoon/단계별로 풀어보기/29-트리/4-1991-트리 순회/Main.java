import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Tree tree = new Tree();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char value = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree.add(value, left, right);
        }

        bw.write(tree.getAnswer());

        bw.flush();
        bw.close();
    }
}

class Tree {

    private Node root;

    private final StringBuilder sb = new StringBuilder();

    public void add(char value, char left, char right) {
        if (root == null) {
            root = new Node(value);
            root.setLeft(left != '.' ? new Node(left) : null);
            root.setRight(right != '.' ? new Node(right) : null);
        } else {
            addRecursive(root, value, left, right);
        }
    }

    private void addRecursive(Node current, char value, char left, char right) {
        if (current == null) {
            return;
        }

        if (current.getValue() == value) {
            current.setLeft(left != '.' ? new Node(left) : null);
            current.setRight(right != '.' ? new Node(right) : null);
        } else {
            addRecursive(current.getLeft(), value, left, right);
            addRecursive(current.getRight(), value, left, right);
        }
    }

    public String getAnswer() {
        preOrder(root);
        sb.append('\n');
        inOrder(root);
        sb.append('\n');
        postOrder(root);

        return sb.toString();
    }

    private void preOrder(Node node) {
        if (node != null) {
            sb.append(node.getValue());
            if (node.getLeft() != null) {
                preOrder(node.getLeft());
            }
            if (node.getRight() != null) {
                preOrder(node.getRight());
            }
        }
    }

    private void inOrder(Node node) {
        if (node != null) {
            if (node.getLeft() != null) {
                inOrder(node.getLeft());
            }
            sb.append(node.getValue());
            if (node.getRight() != null) {
                inOrder(node.getRight());
            }
        }
    }

    private void postOrder(Node node) {
        if (node != null) {
            if (node.getLeft() != null) {
                postOrder(node.getLeft());
            }
            if (node.getRight() != null) {
                postOrder(node.getRight());
            }
            sb.append(node.getValue());
        }
    }
}

class Node {

    private final char value;
    private Node left;
    private Node right;

    public Node(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public char getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
