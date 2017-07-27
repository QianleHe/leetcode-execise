package Collection.LinkedListDemo;

public class Node {
    Node previous;
    Object object;
    Node next;

    public Node(){}

    public Node(Node previous, Object object, Node next) {
        this.previous = previous;
        this.object = object;
        this.next = next;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Object getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
