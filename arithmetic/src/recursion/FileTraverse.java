package recursion;

import java.io.File;

/**
 * @Description: Java中使用递归方法遍历文件夹下的所有文件
 * @Author: zhangxy
 * @Date: Created in 10:43 2019/9/20
 * @Modified By:
 */
public class FileTraverse {

    public static void main(String[] args) {
        //文件夹路径
        String path = "D:\\文档\\Java资料";
        traverseFolder(path);
    }

    private static void traverseFolder(String path) {
        // 获取指定路径下面的文件
        File file = new File(path);
        // 判断文件是否存在
        if (file.exists()) {
            // 获取该目录下所有文件
            File[] files = file.listFiles();
            // 判断文件是否为空
            if (null == files || files.length == 0) {
                System.out.println("文件夹是空的！");
                return;
            } else {
                // 利用foreach 进行遍历
                for (File f : files) {
                    // 判断是文件还是文件夹
                    if (f.isDirectory()) {
                        // （getAbsolutePath())获取文件绝对路径
                        System.out.println("文件夹：" + f.getAbsolutePath());
                        // 递归调用
                        traverseFolder(f.getAbsolutePath());
                    } else {
                        System.out.println("文件：" + f.getAbsolutePath());
                    }
                }
            }

        } else {
            System.out.println("文件不存在！");
        }
    }
}

