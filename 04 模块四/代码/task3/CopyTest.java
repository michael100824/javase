package task3;

import java.io.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  使用线程池将一个目录中的所有内容拷贝到另外一个目录中，包含子目录中的内容。
 */
public class CopyTest {

    public static void main(String[] args) {

        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //copy文件
        copyFilesToTarget(new File("/Users/junzhang/TEST"),"/Users/junzhang/TEST_COPY",executorService);
        //关闭线程池
        executorService.shutdown();
    }

    public static void copyFilesToTarget(File file,String targetPath,ExecutorService executorService) {

        if (file == null || !file.exists()) {
            return;
        }

        File target = new File(targetPath);
        if (!target.exists()) {
            target.mkdir();
            System.out.println("创建目标路径：" + target.getPath());
        }

        if (file.isDirectory()) {
            File dir = new File(targetPath,file.getName());
            System.out.println("创建子目录： " + dir.getPath());
            dir.mkdir();
            File[] files = file.listFiles();
            //递归遍历子文件
            if (files != null && files.length > 0) {
                for (File file1 : files) {
                    copyFilesToTarget(file1,dir.getPath(),executorService);
                }
            }
        }

        if (file.isFile()) {
            System.out.println("开始拷贝：" + file.getPath());
            executorService.submit(() -> copyFile(file,new File(targetPath,file.getName())));
        }
    }

    public static void copyFile(File file, File targetFile) {
        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(file));
            bos = new BufferedOutputStream(new FileOutputStream(targetFile));

            byte[] bArr = new byte[1024];
            int res = 0;
            while ((res = bis.read(bArr)) != -1) {
                bos.write(bArr,0,res);
            }
            System.out.println(Thread.currentThread().getName() + " 拷贝文件完成： " + targetFile.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != bos) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != bis) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}