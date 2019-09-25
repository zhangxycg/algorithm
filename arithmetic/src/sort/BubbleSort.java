package sort;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.concurrent.ForkJoinPool;

/**
 * @Description: 冒泡排序算法
 * @Author: zhangxy
 * @Date: Created in 16:34 2019/9/25
 * @Modified By:
 */
public class BubbleSort {

    public static void main(String[] args) {
        System.out.println("输入要排序的值，输入的每个值用逗号隔开:");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();

        // 将字符串按照',"拆分成字符串数组
        String[] strArray = str.split(",");
        // 新建数组用来存储拆分出来的每个值
        int[] array = new int[strArray.length];
        // 给数组循环遍历赋值
        for (int i = 0; i < strArray.length; i++) {
            array[i] = Integer.parseInt(strArray[i]);
        }

        System.out.println("排序前的数组：" + Arrays.toString(array));

        // 用冒泡排序算法对数组进行排序
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                int temp = 0;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        System.out.println("排序后的数组：" + Arrays.toString(array));

    }
}
