import java.util.*;

class GenericTree<T> {
    T data;
    ArrayList<GenericTree<T>> children = new ArrayList<>();
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> treeInput = new ArrayList<>(Arrays.asList(10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1));
        GenericTree<Integer> root = constructGenericTree(treeInput);
        display(root);
        int ans = sizeOfGenericTree(root);
        System.out.println(ans);
    }

    public static GenericTree<Integer> constructGenericTree(ArrayList<Integer> treeInput) {
        GenericTree<Integer> root = new GenericTree<>();
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

        return root;
    }

    public static void display(GenericTree<Integer> node) {
        String str = node.data + " --> ";
        for(GenericTree<Integer> child: node.children) {
            str += child.data + ", ";
        }
        str += " ---- (Done)";
        System.out.println(str);

        for(GenericTree<Integer> child: node.children) {
//            System.out.println(child.data);
            display(child);
        }
    }

    public static int sizeOfGenericTree(GenericTree<Integer> root) {
//        Queue<GenericTree<Integer>> q = new LinkedList<>();
//        q.offer(root);
//        int size = 0;
//
//        while(!q.isEmpty()) {
//            GenericTree<Integer> node = q.peek();
//            size++;
//            for(GenericTree<Integer> n: node.children) {
//                q.offer(n);
//            }
//            q.poll();
//        }
//
//        return size;

        // recursive solution
        int size = 0;
        for(GenericTree<Integer> node : root.children) {
            int sizeOfSubtree = sizeOfGenericTree(node);
            size += sizeOfSubtree;
        }

        size += 1;
        return size;
    }
}