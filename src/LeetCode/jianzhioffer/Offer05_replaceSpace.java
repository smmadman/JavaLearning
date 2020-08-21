package LeetCode.jianzhioffer;

//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

public class Offer05_replaceSpace {
    public static void main(String[] args) {

    }

    public static String replaceSpace(String s) { // 复制一个（初始长度为3倍的空数组）
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }
}
