package collections;

/**
 * @author fangjie
 * @Description: ${todo}
 * @date 2020/1/17 10:01
 */
public class SortedLinkedList<E extends Comparable<E>> {


    private Node<E> first;

    private int size;

    public SortedLinkedList() {
        this.first = null;
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }


    public void addFirst(E value) {
        Node<E> newNode = new Node<>(value);
        Node<E> prevNode = null;
        Node<E> current = first;
        //循环获取到 比插入元素小的元素
        while (current != null && value.compareTo(current.value) > 0) {
            prevNode = current;
            current = current.next;
        }
        //插入元素为最小值
        if (prevNode == null) {
            first = newNode;
        } else {
            prevNode.next = newNode;
        }
        newNode.next = current;
        size++;
    }

    public E removeFirst() {
        if (null == first) {
            throw new RuntimeException("the list is empty");
        }
        Node<E> temp = first;
        first = first.next;
        size--;
        return temp.value;
    }

    public boolean remove(E value) {
        if (null == first) {
            return false;
        }

        Node<E> current = first;
        if (current.value == value) {
            first = current.next;
            return true;
        }

        while (current.next != null) {
            if (current.next.value == value) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean removeAll(E value) {
        //删除头部是指定元素
        while (first != null && first.value == value) {
            first = first.next;
        }
        if (first == null) {
            return true;
        }

        Node<E> current = first;
        while (current.next != null) {
            if (current.next.value == value) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return true;
    }

    public boolean contains(E value) {
        Node<E> current = first;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node<E> current = first;
        while (current != null) {
            builder.append(current.value).append(",");
            current = current.next;
        }
        builder = builder.replace(builder.length() - 1, builder.length(), "");
        return builder.toString();
    }

    private static class Node<E> {

        E value;

        Node<E> next;

        public Node(E value) {
            this.value = value;
        }

        @Override
        public String toString() {
            if (value == null) {
                return "";
            }
            return value.toString();
        }
    }


    public static void main(String[] args) {
        SortedLinkedList<String> linkedList = new SortedLinkedList<>();
        linkedList.addFirst("a");
        linkedList.addFirst("b");
        linkedList.addFirst("c");
        System.out.println(linkedList);
    }
}
