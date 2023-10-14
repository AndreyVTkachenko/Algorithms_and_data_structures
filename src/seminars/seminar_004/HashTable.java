package seminars.seminar_004;

import java.lang.reflect.Array;

public class HashTable<K, V> {

    public static final int INT_BASKET_SIZE = 16;
    public static final double LOAD_FACTOR = 0.75;

    private int size;

    private Basket[] baskets;

    public HashTable() {
        this(INT_BASKET_SIZE);
    }

    public HashTable(int initSize) {
        baskets = (Basket[]) Array.newInstance(Basket.class, initSize);
    }

    private void resize() {
        int newSize = baskets.length * 2;
        Basket[] oldBasket = baskets;
        baskets = (Basket[]) new Object[newSize];
        for (int i = 0; i < oldBasket.length; i++) {
            Basket basket = oldBasket[i];
            Basket.Node node = basket.head;

            while (node != null) {
                add(node.value.key, node.value.value);
            }
        }
    }

    public V find(K key) {
        int index = calculateBasketIndex(key);
        return baskets[index].find(key);
    }

    public void add(K key, V value) {
        if (baskets != null) {
            if ((double) size / baskets.length >= LOAD_FACTOR) {
                resize();
            }
        }

        int index = calculateBasketIndex(key);
        Basket basket = baskets[index];
        if (basket == null) {
            basket = new Basket();
            baskets[index] = basket;
        }
        basket.add(new Entry(key, value));
        size++;
    }

    public void removeValue(K key) {
        int index = calculateBasketIndex(key);
        Basket basket = baskets[index];
        basket.remove(key);
        size--;
    }

    private int calculateBasketIndex(K key) {
        return Math.abs(key.hashCode()) % baskets.length;
    }

    private class Entry {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private class Basket {

        private Node head;

        public V find(K key) {
            Node currentNode = head;
            while (currentNode != null) {
                if (currentNode.value.key.equals(key)) {
                    return currentNode.value.value;
                }
                currentNode = currentNode.next;
            }
            return null;
        }

        public void add(Entry entry) {
            Node node = new Node();
            node.value = entry;
            if (head == null) {
                head = node;
            } else {
                node.next = head;
                head = node;
            }
        }

        public void remove(K key) {
            Node node = new Node();
            if (head == null) {
                return;
            } else {
                Node current = head;
                if (current.value.key.equals(key)) {
                    head = head.next;
                    return;
                } else {
                    while (current.next != null) {
                        if (current.next.value.key.equals(key)) {
                            current.next = current.next.next;
                        } else {
                            current = current.next;
                        }
                    }
                }
            }
        }

        private class Node {
            private Node next;
            private Entry value;
        }
    }
}