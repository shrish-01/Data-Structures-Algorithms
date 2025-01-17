import java.util.*;

class GenericTree<T> {
    T data;
    ArrayList<GenericTree<T>> children = new ArrayList<>();
    public GenericTree() {};
    public GenericTree(T data) {
        this.data = data;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> treeInput = new ArrayList<>(Arrays.asList(10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1));
        GenericTree<Integer> root = constructGenericTree(treeInput);
//        display(root);
//        int ans = sizeOfGenericTree(root);
//        int ans = maximumOfGenericTree(root);
//        int ans = heightOfGenericTree(root);
//        System.out.println(ans);
//        genericTreeTraversal(root);
//        levelOrderTraversal(root);
        levelOrderZigZag(root);
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

    public static int maximumOfGenericTree(GenericTree<Integer> root) {
        int maxi = Integer.MIN_VALUE;
        for(GenericTree<Integer> node: root.children) {
            int maxOfSubtree = maximumOfGenericTree(node);
            maxi = Math.max(maxi, maxOfSubtree);
        }

        maxi = Math.max(maxi, root.data);
        return maxi;
    }

    public static int heightOfGenericTree(GenericTree<Integer> root) {
        // in terms of edges, initialize height as -1, and in terms of node, initialize as 0;
        int height = 0;
        for(GenericTree<Integer> child: root.children) {
            int childHeight = heightOfGenericTree(child);
            height = Math.max(childHeight, height);
        }
        height += 1;
        return height;
    }

    public static void genericTreeTraversal(GenericTree<Integer> root) {
        System.out.println("Node Pre " + root.data);

        for(GenericTree<Integer> child: root.children) {
            System.out.println("Edge Pre " + root.data + "--" + child.data);
            genericTreeTraversal(child);
            System.out.println("Edge Post " + root.data + "--" + child.data);
        }

        System.out.println("Node Post " + root.data);
    }

    public static void levelOrderTraversal(GenericTree<Integer> root) {
        Queue<GenericTree<Integer>> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);

        while(!q.isEmpty()) {
            GenericTree<Integer> node = q.poll();
            if(node == null) {
                System.out.println();
                if(!q.isEmpty()) {
                    q.offer(null);
                }
            } else {
                System.out.print(node.data + " ");
                for(GenericTree<Integer> n: node.children) {
                    q.offer(n);
                }
            }
        }
    }

    public static void levelOrderZigZag(GenericTree<Integer> root) {
        Stack<GenericTree<Integer>> parentStack = new Stack<>();
        Stack<GenericTree<Integer>> childStack = new Stack<>();
        parentStack.push(root);
        int level = 1;
        while(!parentStack.isEmpty() || !childStack.isEmpty()) {
            GenericTree<Integer> node = parentStack.pop();
            if(level % 2 == 0) { // even, traverse right to left
                System.out.print(node.data + " ");
                for(int i = node.children.size() - 1; i >= 0; i--) {
                    childStack.push(node.children.get(i));
                }
            } else { // odd, traverse left to right
                System.out.print(node.data + " ");
                for(GenericTree<Integer> n: node.children) {
                    childStack.push(n);
                }
            }
            if(parentStack.isEmpty()) {
                level++;
                parentStack = childStack;
                childStack = new Stack<GenericTree<Integer>>();
                System.out.println();
            }
        }
    }
}