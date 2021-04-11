/**
 * 回文数
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        /*
        1. x 是负数，不可能是回文数
        2. x 最后一位是 0 ，不可能是回文数，因为整数首位不可能是 0
        3. 0 为回文数
         */
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        // 当原始数字处理到小于或等于反转后的数字后，意味着处理了一半了
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        /*
         1. 偶数时相等时为回文数
         2. 当奇数时 123 / 10 = 12 , 处理后的数据等于源数据时为回文数
         */
        return revertedNumber == x || x == revertedNumber / 10;
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println("palindromeNumber.isPalindrome(12) = " + palindromeNumber.isPalindrome(12));
    }
}
