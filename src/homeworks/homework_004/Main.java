package homeworks.homework_004;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
//        final RedBlackTree testTree = new RedBlackTree();
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
//            while (true) {
//                int key = Integer.parseInt(reader.readLine());
//                testTree.add(key);
//                System.out.println("finish");
//            }
//        } catch (Exception e) {
//        }

        RedBlackTree tree = new RedBlackTree();
        tree.add(5);
        tree.add(1);
        tree.add(3);
        tree.add(8);
        tree.add(6);
        tree.add(11);
        tree.add(7);
        tree.add(10);
        tree.add(2);
        tree.add(4);
        tree.add(12);
        tree.add(9);
        tree.printTree();
    }
}