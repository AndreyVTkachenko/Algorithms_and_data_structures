package seminars.seminar_004;

// Начинаем реализацию хэш-таблицы с подготовки структуры и необходимых классов.
// Давайте напишем реализацию односвязного списка, в котором мы и будем хранить пары ключ-значение.
// Стоит обратить внимание, что можно использовать как дженерики, для обобщения возможных типов ключей и значений,
// так и заранее определить для себя конкретные типы, которые будут использоваться в качестве ключа и значения.
// Оба подхода допустимы для реализации.

// Реализуем метод поиска данных по ключу в хэш-таблице.
// Теперь, когда у нас есть базовая структура нашей хэш-таблицы, можно написать алгоритм поиска элементов,
// включающий в себя поиск нужного бакета и поиск по бакету.

public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable<>();
        hashTable.add(1, 5);
        System.out.println(hashTable.find(1));
        hashTable.add(4, 8);
        System.out.println(hashTable.find(4));
        hashTable.add(5, 9);
        System.out.println(hashTable.find(5));
        hashTable.add(6, 9);
        System.out.println(hashTable.find(6));
        hashTable.add(7, 20);
        System.out.println(hashTable.find(7));
        hashTable.add(8, 22);
        System.out.println(hashTable.find(8));
    }
}
