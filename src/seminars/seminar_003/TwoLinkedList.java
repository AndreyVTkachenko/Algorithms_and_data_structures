package seminars.seminar_003;

// Расширяем структуру связного списка до двухсвязного.

public class TwoLinkedList {

    public Node head;

    private Node tail;

    public void addFirst(int value) {
        Node node = new Node(value);
        node.value = value;
        // todo посмотреть позже необходимо ли условие для данного метода
        if (head != null) {
            node.next = head;
            head.previous = node;
        }
        else {
            tail = node;
        }
        head = node;
    }

    public void deleteFirst() {
        if (head != null && head.previous != null) {
            head.next.previous = null;
            head = head.next;
        } else {
            head = null;
            tail = null;
        }
    }


    public void addLast(int value) {
        Node node = new Node(value);
        if (tail == null) { // список пуст
            tail = node;
        } else { // список наполнен
            Node current = tail;
            tail.next = node;
            node.previous = current;
        }
        tail = node;
    }

    public void deleteLast() {
        if (tail != null && tail.previous != null) {
            tail.previous.next = null;
            tail = tail.previous;
        } else {
            head = null;
            tail = null;
        }
    }

    public void sort() {
        boolean flag;
        do {
            flag = false;
            Node node = head;
            while (node != null && node.next != null) {
                if (node.value > node.next.value) {
                    Node before = node.previous;
                    Node after = node.next.next;
                    Node current = node;
                    Node next = node.next;

                    current.next = after;
                    current.previous = next;
                    next.next = current;
                    next.previous = before;

                    if (before != null) {
                        before.next = next;
                    }
                    else {
                        head = next;
                    }
                    if (after != null) {
                        after.previous = current;
                    }
                    else {
                        tail = current;
                    }
                    flag = true;
                }
                node = node.next;
            }
        }while (flag);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node current = head;
        stringBuilder.append(current.value).append(", ");
        while (current.next != null) {
            stringBuilder.append(current.value).append(", ");
            current = current.next;
        }
        return "LinkedList{" + stringBuilder + '}';
    }

    public void print() {
        Node node = head;
        while (node != null) {
            System.out.println("current = " + node.value);
            node = node.next;
        }
    }

    public class Node {
        public int value;
        private Node next;
        private Node previous;

        public Node(int value) {
            this.value = value;
            this.next = null;
            this.previous = null;
        }

        public Node() {
        }
    }

    public boolean isContains(int target) {
        return find(target) != null ? true : false;
    }

    public Node find(int target) {
        while (head != null) {
            if (head.value == target) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}