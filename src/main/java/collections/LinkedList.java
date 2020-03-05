package collections;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fangjie
 * @Description: ${todo}
 * @date 2020/1/17 10:01
 */
public class LinkedList<E> {


    private Node<E> first;

    private int size;

    public LinkedList() {
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
        newNode.next = first;
        first = newNode;
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

//    public boolean removeAll(E value) {
//        if (null == first) {
//            return false;
//        }
//        Node<E> temp = new Node<>(null);
//
//        temp.next = first;
//        Node<E> current = first;
//        Node<E> prevNode = temp;
//
//        while (current != null) {
//            if(current.value == value){
//                prevNode.next = current.next;
//            }else{
//                prevNode=current;
//            }
//            current = current.next;
//        }
//        System.out.println(this);
//
////        Node<E> current = first;
////        Node<E> prevNode = null;
////        while (current != null) {
////            if (current.next == null) {
////                if (current.value == value) {
////                    first = current.next;
////                    return true;
////                } else {
////                    return false;
////                }
////            }
////            if (current.next.value == value) {
////                prevNode = current;
////            }
////            current = current.next;
////        }
////        prevNode.next = prevNode.next.next;
//
//        return true;
//    }

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
        if (builder.length() > 0) {
            builder = builder.replace(builder.length() - 1, builder.length(), "");
        }

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
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addFirst("c");
        linkedList.addFirst("a");
        linkedList.addFirst("c");
        linkedList.addFirst("b");
        linkedList.addFirst("c");
        linkedList.addFirst("c");
        System.out.println(linkedList);
        linkedList.removeAll("c");
        System.out.println(linkedList);
    }
}
