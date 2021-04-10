import java.util.Stack;

/**
 * 删除字符中的所有相邻重复项
 */
public class RemoveDuplicateCharacters {
    public class CharWithCount {
        public char c;
        public int count;

        public CharWithCount (char c, int count) {
            this.c = c;
            this.count = count;
        }

        @Override
        public String toString() {
            return "CharWithCount{" +
                    "c=" + c +
                    ", count=" + count +
                    '}';
        }
    }

    public String remove(String str) {
        Stack<CharWithCount> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            // 栈为空
            if (stack.isEmpty()) {
                stack.push(new CharWithCount(c , 1));
                continue;
            }

            CharWithCount topChar = stack.peek();
            // 如果插入的元素与栈顶元素不同
            if (topChar.c != c) {
                stack.push(new CharWithCount(c, 1));
                continue;
            }

            // 如果插入的元素和栈顶元素相同，并且栈顶元素已经出现了两次
            if (stack.peek().count == 2) {
                stack.pop();
                continue;
            }

            // 栈顶元素相同，但不满足消消乐条件
            topChar.count++;
        }

        char[] resultArr = new char[stack.size()];
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop().c);
        }

        return result.reverse().toString();
    }


    public static void main(String[] args) {
        RemoveDuplicateCharacters removeDuplicateCharacters = new RemoveDuplicateCharacters();
        String result = removeDuplicateCharacters.remove("abbaaabcc");
        System.out.println(result);
    }
}
