/**
 *   实现将指定目录中的所有内容删除，包含子目录中的内容都要全部删除。
 */

package task2;

import java.io.File;

public class DeleteAll {

    public static final String TEST_PATH = "/Users/junzhang/TEST";

    public static void main(String[] args) {

        File file = new File(TEST_PATH);
        deleteAllFile(file);
    }

    public static void deleteAllFile(File file) {

        if (file == null) {
            return;
        }

        if (file.isFile()) {
            file.delete();
            System.out.println(file.getName() + "已经删除");
        }

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null && files.length > 0) {
                for (File f : files) {
                    deleteAllFile(f); // 递归调用删除内部文件
                }
            }
            file.delete(); //内部文件删除完成后，删除自身
            System.out.println(file.getName() + "已经删除");
        }
    }


}
