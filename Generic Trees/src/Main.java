import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class GenericTree<T> {
    T data;
    ArrayList<GenericTree<T>> children = new ArrayList<>();
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> treeInput = new ArrayList<>(Arrays.asList(10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1));
        constructGenericTree(treeInput);
    }

    public static void constructGenericTree(ArrayList<Integer> treeInput) {
        GenericTree<Integer> root;
        Stack<GenericTree<Integer>> st = new Stack<>();
        for(int i = 0; i < treeInput.size(); i++) {
            if(treeInput.get(i) == -1) {
                st.pop();
            } else {
                GenericTree<Integer>  node = new GenericTree<>();
                node.data = treeInput.get(i);

                if(!st.isEmpty()) {
                    st.peek().children.add(node);
                } else {
                    root = node;
                }

                st.push(node);
            }
        }
    }
}