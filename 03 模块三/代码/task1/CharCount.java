/**
 * 编程统计字符串"ABCD123!@#$%ab"中大写字母、小写字母、数字、其它字符的个数并打印出来。
 */

package task1;

public class CharCount {

    private String str;
    private int upperCount = 0;
    private int lowerCount = 0;
    private int numberCount = 0;
    private int specialCount = 0;
    private byte[] arr;

    public CharCount() {
    }

    public CharCount(String str) {
        this.str = str;
    }

    public void count() {
        // 将当前字符串内容转换为byte数组并返回
        arr = str.getBytes();
        // 遍历arr
        for (byte bt : arr) {
            if (bt >= 65 && bt <= 90) {
                upperCount++;
            } else if (bt >= 97 && bt <= 122) {
                lowerCount++;
            } else if (bt >= 48 && bt <= 57) {
                numberCount++;
            } else specialCount++;
        }
    }

    // 返回给定的字符串
    public String getStr() {
        return str;
    }

    // 返回大写字母的个数
    public int getUpperCount() {
        return upperCount;
    }

    // 返回小写字母的个数
    public int getLowerCount() {
        return lowerCount;
    }

    // 返回数字的个数
    public int getNumberCount() {
        return numberCount;
    }

    // 返回特殊字符的个数
    public int getSpecialCount() {
        return specialCount;
    }


}
