import java.util.Arrays;

/**
 * 基于数组的 环形队列
 */
public class CircularQueque {
    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public CircularQueque(int n) {
        this.items = new String[n];
        this.n = n;
    }

    public boolean enqueque(String item) {
        // 队列满了
        if ((tail + 1) % n == head) return false;
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    public String dequeque(String item) {
        // 空队列
        if (tail == head) return null;
        String value = items[head];
        head = (head + 1) % n;
        return value;
    }

    @Override
    public String toString() {
        return "CircularQueque{" +
                "items=" + Arrays.toString(items) +
                ", n=" + n +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }

    public static void main(String[] args) {
        CircularQueque circularQueque = new CircularQueque(7);
        circularQueque.enqueque("a");
        circularQueque.dequeque("a");

        System.out.println("circularQueque = " + circularQueque);
    }
}
