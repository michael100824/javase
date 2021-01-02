package task1;

public class CharCountTest {
    public static void main(String[] args) {

        //CharCount cc = new CharCount("ABCD123!@#$%ab");
        CharCount cc = new CharCount("AGTCuucl4530&^%$");
        cc.count();
        System.out.println("解析的字符串是：" + cc.getStr());
        System.out.println("大写字母个数是:" + cc.getUpperCount() + "个");
        System.out.println("小写字母个数是：" + cc.getLowerCount() + "个");
        System.out.println("数字个数是：" + cc.getNumberCount() + "个");
        System.out.println("特殊字符个数是：" + cc.getSpecialCount() + "个");

    }
}
