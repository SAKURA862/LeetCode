package 剑指Offer_58_II_左旋转字符串;

/**
 * 直接使用库函数
 */
class Solution {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}

/**
 * 整体反转 + 局部反转
 */
class Solution2 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        int len = sb.length();
        reverseString(sb, 0, len - 1);
        reverseString(sb, 0, len - n - 1);
        reverseString(sb, len - n, len - 1);
        return sb.toString();
    }

    private void reverseString(StringBuilder sb, int start, int end){
        char tmp;
        while (start < end){
            tmp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, tmp);
            start++;
            end--;
        }
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
