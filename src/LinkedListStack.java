import java.util.Stack;

/**
 * 基于链表的栈
 */
public class LinkedListStack {
    public class Node {
        public int data;
        public Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    private Node head = null;

    public void push(int value) {
        Node newNode = new Node(value, null);
        newNode.next = head;
        head = newNode;
    }

    public int pop() {
        if (head == null) return -1;
        int value = head.data;
        head = head.next;
        return value;
    }

    public int peak() {
        if (head == null) return -1;
        return head.getData();
    }

    @Override
    public String toString() {
        return "LinkedListStack{" +
                "head=" + head +
                '}';
    }

    public static void main(String[] args) {
        LinkedListStack linkedListStack = new LinkedListStack();
        linkedListStack.push(1);
        linkedListStack.push(2);
        linkedListStack.push(3);
        linkedListStack.push(4);
        linkedListStack.pop();
        System.out.println(linkedListStack.peak());
        System.out.println("linkedListStack = " + linkedListStack);

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        int value = stack.pop();
        System.out.println(value);
        System.out.println(stack);
    }
}
