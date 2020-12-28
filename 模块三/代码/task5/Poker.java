/**
 * 使用集合实现斗地主游戏的部分功能，要求如下：
 *
 * （1）首先准备 54 张扑克牌并打乱顺序。
 *
 * （2）由三个玩家交替摸牌，每人 17 张扑克牌，最后三张留作底牌。
 *
 * （3）查看三个玩家手中的扑克牌和底牌。
 *
 * （4）其中玩家手中的扑克牌需要按照大小顺序打印，规则如下：
 *
 * 手中扑克牌从大到小的摆放顺序：大王,小王,2,A,K,Q,J,10,9,8,7,6,5,4,3
 */
package task5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class Poker {
    public static void main(String[] args) {
        /*
         * 1组装54张扑克牌
         */
        // 创建Map集合存储
        HashMap<Integer, String> pokerMap = new HashMap<>();
        // 创建花色集合与数字集合
        ArrayList<String> colors = new ArrayList<>();
        ArrayList<String> numbers = new ArrayList<>();

        // 存储花色与数字
        Collections.addAll(colors, "♦", "♣", "♥", "♠");
        Collections.addAll(numbers, "2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");
        // 设置 存储编号变量
        int count = 1;
        pokerMap.put(count++, "大王");
        pokerMap.put(count++, "小王");
        // 创建牌 存储到map集合中
        for (String number : numbers) {
            for (String color : colors) {
                String card = color + number;
                pokerMap.put(count++, card);
            }
        }
        /*
         *  将54张牌顺序打乱
         */
        // 取出编号 集合
        Set<Integer> numberSet = pokerMap.keySet();
        // 因为要将编号打乱顺序 所以 应该先进行转换到 list集合中
        ArrayList<Integer> numberList = new ArrayList<>();
        numberList.addAll(numberSet);

        // 打乱顺序
        Collections.shuffle(numberList);

        //  完成三个玩家交替摸牌，每人17张牌，最后三张留作底牌
        // 发牌的编号
        // 创建三个玩家编号集合和一个底牌编号集合
        ArrayList<Integer> noP1 = new ArrayList<>();
        ArrayList<Integer> noP2 = new ArrayList<>();
        ArrayList<Integer> noP3 = new ArrayList<>();
        ArrayList<Integer> dipaiNo = new ArrayList<>();

        // 发牌的编号
        for (int i = 0; i < numberList.size(); i++) {
            // 获取该编号
            Integer no = numberList.get(i);
            // 发牌
            // 留出底牌
            if (i >= 51) {
                dipaiNo.add(no);
            } else {
                if (i % 3 == 0) {
                    noP1.add(no);
                } else if (i % 3 == 1) {
                    noP2.add(no);
                } else {
                    noP3.add(no);
                }
            }
        }

        // 查看三人各自手中的牌（按照牌的大小排序）、底牌
        // 对手中编号进行排序
        Collections.sort(noP1);
        Collections.sort(noP2);
        Collections.sort(noP3);
        Collections.sort(dipaiNo);

        // 进行牌面的转换
        // 创建三个玩家牌面集合 以及底牌牌面集合
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> dipai = new ArrayList<>();

        // 转换
        for (Integer i : noP1) {
            // 根据编号找到 牌面 pokerMap
            String card = pokerMap.get(i);
            // 添加到对应的 牌面集合中
            player1.add(card);
        }

        for (Integer i : noP2) {
            String card = pokerMap.get(i);
            player2.add(card);
        }

        for (Integer i : noP3) {
            String card = pokerMap.get(i);
            player3.add(card);
        }

        for (Integer i : dipaiNo) {
            String card = pokerMap.get(i);
            dipai.add(card);
        }

        // 查看
        System.out.println("玩家一：" + player1);
        System.out.println("玩家二：" + player2);
        System.out.println("玩家三：" + player3);
        System.out.println("底牌：" + dipai);
    }
}