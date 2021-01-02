package task2;

import java.util.Collection;

public class MaxSubStringTest {
    public static void main(String[] args) {
        //MaxSubstring maxSubstring = new MaxSubstring("asdafghjka","aaasdfg");
        MaxSubstring maxSubstring = new MaxSubstring("abcdggif","aftrabcder12");
        String s = maxSubstring.stringCompare();
        System.out.println("最大子串为：" + s);
    }

}
