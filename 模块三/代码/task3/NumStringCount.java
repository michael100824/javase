/**
 * 准备一个 HashMap 集合，统计字符串"123,456,789,123,456"中每个数字字符串出现的次数并打印出来。
 * <p>
 * 如：
 * <p>
 * 123 出现了 2 次
 * <p>
 * 456 出现了 2 次
 * <p>
 * 789 出现了 1 次
 */
package task3;

import java.util.*;

public class NumStringCount {
    private String str;

    public NumStringCount() {
    }

    public NumStringCount(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }


    public void countString() {
        int start = 0;
        List<String> lt1 = new ArrayList();
        while (start < str.length()) {
            int i = str.indexOf(",", start);
            // 判断是否是最后一个逗号，防止IndexOutOfBoundsException
            if (i != -1) {
                String key = str.substring(start, i);
                lt1.add(key);
                start = i + 1;
            } else {
                String key = str.substring(start);
                lt1.add(key);
                break;
            }
        }

        HashMap<String, Integer> countMap = new HashMap<>();
        // 遍历List中每个元素
        for (String s : lt1) {
            // 如果HashMap中已经存在，将原value+1
            if (countMap.containsKey(s)) {
                countMap.put(s, countMap.get(s) + 1);
            } else {
                // 否则直接放入HashMap中
                countMap.put(s, 1);
            }
        }
        // 输入HashMap
        for (Map.Entry entry : countMap.entrySet()) {
            System.out.println(entry.getKey() + " 出现了 " + entry.getValue() + " 次。");
        }
    }
}


