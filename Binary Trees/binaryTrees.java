import java.util.Scanner;

class BTNode<T> {
    public T data;
    public BTNode<T> left;
    public BTNode<T> right;

    public BTNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class binaryTrees {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter root");
        BTNode<Integer> root = new BTNode<Integer>(scn.nextInt());
        System.out.println("Enter left element");
        root.left = new BTNode<Integer>(scn.nextInt());
        System.out.println("Enter right element");
        root.right = new BTNode<Integer>(scn.nextInt());

        System.out.println(root.data);
        System.out.println(root.left.data);
        System.out.println(root.right.data);
    }
}