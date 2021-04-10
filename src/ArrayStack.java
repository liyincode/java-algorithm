import java.util.Arrays;

public class ArrayStack {
    // 数组
    private int[] items;
    // 栈中元素个数
    private int count;
    // 栈大小
    private int n;

    public ArrayStack(int n) {
        this.items = new int[n];
        this.count = 0;
        this.n = n;
    }

    /**
     * 入栈
     * @param item
     * @return
     */
    public boolean push(int item) {
        if (count == n) return false;

        items[count] = item;
        count++;
        return true;
    }

    /**
     * 弹出
     * @return
     */
    public int pop() {
        if (count == 0) return -1;
        int value = items[count - 1];
        count--;

        return value;
    }

    /**
     * 获取栈中最后一位元素的值
     * @return
     */
    public int peek() {
        if (count == 0) return -1;

        return items[count - 1];
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "items=" + Arrays.toString(items) +
                ", count=" + count +
                ", n=" + n +
                '}';
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(6);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);
        arrayStack.push(6);
        System.out.println(arrayStack.pop());

        System.out.println(arrayStack);
    }
}


