/**
 * 编程获取两个指定字符串中的最大相同子串。
 * <p>
 * 如： s1="asdafghjka", s2="aaasdfg" 他们的最大子串为"asd"
 * <p>
 * 提示： 将短的那个串进行长度依次递减的子串与较长的串比较。
 */
package task2;

import java.util.ArrayList;
import java.util.Collection;

public class MaxSubstring {

    private String str1;
    private String str2;

    public MaxSubstring() {
    }

    public MaxSubstring(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }

    public String stringCompare() {
        Collection c1 = new ArrayList();
        String shorterStr = (str1.length() < str2.length()) ? str1 : str2;
        String longerStr = (str1.length() >= str2.length()) ? str1 : str2;

        // 如果两个字符串内容完全相同，则直接返回任意一个字符串
        if (shorterStr.equals(longerStr)) {
            return shorterStr;
        } else {
            // diff是记录substring开始位置和终止位置的差
            for (int diff = shorterStr.length() - 1; diff > 0; diff--) {
                // k代表终止位置，
                int k = shorterStr.length() - 1;
                while (k >= diff) {
                    // j代表起始位置
                    int j = k - diff;
                    String ss = shorterStr.substring(j, k);
                    // 短字符串的substring与长字符串的substring比较
                    for (int i = 0; i < longerStr.length() - ss.length(); i++) {
                        if (ss.equals(longerStr.substring(i, ss.length() + i))) {
                            return ss;
                        }
                    }
                    k--;
                }

            }
        }
        return null;
    }

}
