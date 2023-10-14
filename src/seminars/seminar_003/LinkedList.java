package seminars.seminar_003;

// Реализовать простой односвязный список
// Написать только структуру, методы не нужны

// Реализуем метод добавления новых элементов в начало списка и удаление первого элемента связного списка.
// Односвязный список всегда имеет ссылку на первый элемент последовательности, потому именно с реализации
// методов для первого элемента последовательности стоит начать

// Реализуем метод поиска элемента в односвязном списке для проверки наличия элемента внутри списка.
// Для корректной работы со связным список необходимо понимать, как именно можно обходить все значения внутри
// связного списка.
// Для нашего примера проще всего будет написать метод поиска значения в связном списке и возвращения из метода
// информации о наличии искомого внутри списка.

// Реализуем метод добавления новых элементов в конец списка и удаление последнего элемента связного списка.


public class LinkedList {

    public Node head;

    public void addFirst(int value) {
        Node node = new Node(value);
        node.value = value;
        // todo посмотреть позже необходимо ли условие для данного метода
        if (head != null) {
            node.next = head;
        }
        head = node;
    }

    public void deleteFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    public void addLast(int value) {
        Node node = new Node(value);
        if (head == null) { // список пуст
            head = node;
        } else { // список наполнен
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    }

    public void deleteLast() {
        if (head != null) {
            Node current = head;
            while (current.next != null) {
                if (current.next.next == null) {
                    current.next = null;
                    return;
                }
                current = current.next;
            }
            head = null;
        }
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
        Node current = head;
        while (current != null) {
            System.out.println("current = " + current.value);
            current = current.next;
        }
    }

    public class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
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
