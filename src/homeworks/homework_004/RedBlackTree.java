package homeworks.homework_004;

public class RedBlackTree {
    /*
     * Красно-черное дерево Корень всегда черный Новый элемент по умолчанию красный
     * (для частного левостороннего дерева красный элемент слева) Все дети красного
     * узла должны быть черные Все листья будут черными и на уровне null Цвет нужен
     * для алгоритма балансировки дерева
     */

    private Node root;

    private Node LSwap(Node node) {
        Node leftChild = node.leftChild;
        Node betweenChild = leftChild.rightChild; // элемент, который меняет своих родителей
        leftChild.rightChild = node;
        node.leftChild = betweenChild;
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;
    }

    private Node RSwap(Node node) {
        Node rightChild = node.rightChild;
        Node betweenChild = rightChild.leftChild;
        rightChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }

    private void colorSwap(Node node) { // Возникает в особой ситуации, когда оба ребенка красные
        node.rightChild.color = Color.BLACK;
        node.leftChild.color = Color.BLACK;
        node.color = Color.RED;
    }

    public void add(int key) {
        if (root != null) {
            boolean result = addNode(root, key);
            root = rebalanced(root);
            root.color = Color.BLACK;
        } else {
            root = new Node();
            root.color = Color.BLACK;
            root.key = key;
        }
    }

    private boolean addNode(Node node, int key) {
        if (key == node.key) { // Исключаем дублирование элементов
            return false;
        } else {
            if (key < node.key) {
                if (node.leftChild != null) {
                    boolean result = addNode(node.leftChild, key);
                    node.leftChild = rebalanced(node.leftChild);
                    return result;
                } else {
                    node.leftChild = new Node();
                    node.leftChild.color = Color.RED;
                    node.leftChild.key = key;
                    return true;
                }
            } else {
                if (node.rightChild != null) {
                    boolean result = addNode(node.rightChild, key);
                    node.rightChild = rebalanced(node.rightChild);
                    return result;
                } else {
                    node.rightChild = new Node();
                    node.rightChild.color = Color.RED;
                    node.rightChild.key = key;
                    return true;
                }

            }
        }
    }

    private Node rebalanced(Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.rightChild != null && result.rightChild.color == Color.RED
                    && (result.leftChild == null || result.leftChild.color == Color.BLACK)) {
                needRebalance = true;
                result = RSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED && result.leftChild.leftChild != null
                    && result.leftChild.leftChild.color == Color.RED) {
                needRebalance = true;
                result = LSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED && result.rightChild != null
                    && result.rightChild.color == Color.RED) {
                needRebalance = true;
                colorSwap(result);
            }
        } while (needRebalance);
        return result;
    }

    public void printTree() {printTree(root);
    }

    private void printTree(Node node) {
        if (node.leftChild != null) {
            printTree(node.leftChild);
        }
        System.out.print(node.key + " ");
        if (node.rightChild != null) {
            printTree(node.rightChild);
        }
    }

    private static class Node {
        int key;
        Node leftChild;
        Node rightChild;
        Color color;
    }

    enum Color {
        RED, BLACK
    }
}