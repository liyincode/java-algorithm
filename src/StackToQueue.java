import java.util.Stack;

/**
 * 用栈实现队列
 */
public class StackToQueue {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> tmpStack = new Stack<>();

    public void enqueue (Integer data) {
        stack.push(data);
    }

    public Integer dequeue () {
        if (stack.isEmpty()) return null;
        while (!stack.isEmpty()) {
            tmpStack.push(stack.pop());
        }

        Integer result = tmpStack.pop();
        while (!tmpStack.isEmpty()) {
            stack.push(tmpStack.pop());
        }

        return result;
    }

    @Override
    public String toString() {
        return "StackToQueue{" +
                "stack=" + stack +
                ", tmpStack=" + tmpStack +
                '}';
    }

    public static void main(String[] args) {
        StackToQueue stackToQueue = new StackToQueue();
        stackToQueue.enqueue(1);
        stackToQueue.enqueue(2);
        stackToQueue.enqueue(3);
        stackToQueue.enqueue(4);
        stackToQueue.dequeue();

        System.out.println("stackToQueue = " + stackToQueue);
    }
}
