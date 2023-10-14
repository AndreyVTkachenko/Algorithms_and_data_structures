package seminars.seminar_003.homework;

// В классе Answer реализуйте метод reverse, который принимал бы на вход односвязный список и разворачивал бы его.
class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

class Answer {
    Node head;

    public void reverse() {
        if (head != null && head.next != null) {
            reverse(head, head.next);
        }
    }

    private void reverse(Node current, Node next) {
        if (next.next != null) {
            reverse(next, next.next);
        } else {
            head = next;
        }

        next.next = current;
        current.next = null;
    }
}

public class Printer {

    public static void main(String[] args) {
        // Создаем список для тестирования
        Node head;
        if (args.length == 0) {
            head = new Node(1);
            head.next = new Node(2);
            head.next.next = new Node(3);
            head.next.next.next = new Node(4);
        } else {
            head = new Node(Integer.parseInt(args[0]));
            head.next = new Node(Integer.parseInt(args[1]));
            head.next.next = new Node(Integer.parseInt(args[2]));
            head.next.next.next = new Node(Integer.parseInt(args[3]));
        }

        // Разворачиваем список
        Answer ans = new Answer();
        ans.head = head;
        ans.reverse();

        // Выводим результат
        Node current = ans.head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
