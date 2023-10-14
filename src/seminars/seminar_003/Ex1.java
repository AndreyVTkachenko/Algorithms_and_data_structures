package seminars.seminar_003;

public class Ex1 {
    public static void main(String[] args) {
        TwoLinkedList list = new TwoLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        // list.print();
        list.addFirst(3);
        list.addFirst(4);
        // list.print();
        list.addLast(8);
        list.addLast(5);
        list.print();
        list.sort();
        System.out.println("================================================================");
        list.print();
    }
}
