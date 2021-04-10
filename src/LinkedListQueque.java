/**
 * 基于链表的队列
 * 头出尾进
 */
public class LinkedListQueque {
    private class Node {
        public String data;
        public Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data='" + data + '\'' +
                    ", next=" + next +
                    '}';
        }
    }

    private Node head = null;
    private Node tail = null;

    public void enqueque(String value) {
        Node newNode = new Node(value, null);
        if (tail == null) {
            tail = newNode;
            head = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public String dequeque() {
        if (head == null) {
            return null;
        }

        String value = head.data;
        head = head.next;
        /*
         * 如果当只剩下一个节点时，head tail 同时指向这个节点，然后把这个节点给删了，head -> null 了
         * tail 还指向了那个节点，这个时候把 tail 也应该指向 null
         */
        if (head == null) {
            tail = null;
        }
        return value;
    }

    @Override
    public String toString() {
        return "LinkedListQueque{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }

    public static void main(String[] args) {
        LinkedListQueque linkedListQueque = new LinkedListQueque();
        linkedListQueque.enqueque("a");
        linkedListQueque.enqueque("b");
        linkedListQueque.dequeque();
        linkedListQueque.dequeque();
        System.out.println("linkedListQueque = " + linkedListQueque);
    }
}
