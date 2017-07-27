package Collection.LinkedListDemo;

public class MyLinkedList {

    private Node first;

    private Node last;

    private int size;

    public void add(Object obj) {
        Node node = new Node();

        if (size == 0) {
            node.setNext(null);
            node.setObject(obj);
            node.setPrevious(null);
            first = node;
            last = node;
        } else {
            last.setNext(node);
            node.setPrevious(last);
            node.setObject(obj);
            node.setNext(null);
            last = node;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public Node get(int index) {
        if (index < 0 || index > size) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (first == null) {
            return null;
        } else {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        }
    }

    public Node remove(int index) {
        if (index < 0 || index > size) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Node temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        Node pre = temp.previous;
        Node nex = temp.next;
        pre.next = nex;

        return temp;
    }

    public void add(Node node, int index) {
        if (index < 0 || index > size) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Node temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        Node pre = temp.previous;
        pre.next = node;
        temp.previous = node;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add("aaa");
        linkedList.add("bbb");
        System.out.println(linkedList.size());
        System.out.println(linkedList.get(1).object.toString());
    }
}
