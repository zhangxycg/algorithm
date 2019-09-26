package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description: 对冒泡排序进行第二次优化
 * @Author: zhangxy
 * @Date: Created in 10:59 2019/9/26
 * @Modified By:
 */
public class BubbleSort3 {

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

        // 排序
        sort(array);

        System.out.println("排序后的数组：" + Arrays.toString(array));
    }

    /**
     * 用冒泡排序算法对数组进行排序
     *
     * @param array
     */
    private static void sort(int[] array) {

        // 用来交换的临时数
        int temp = 0;
        // 最后一次交换的下标
        int lastSwapIndex = 0;
        // 无序数组的边界，每次比较比到这里为止
        int arrBoundary = array.length - 1;

        for (int i = 0; i < array.length - 1; i++) {
            System.out.println("第" + (i + 1) + "趟");
            // 优化冒泡排序，增加判断位，有序标记，每一轮的初始是true
            boolean flag = true;
            for (int j = 0; j < arrBoundary; j++) {
                // 找最小数，如果前一位比后一位大，则交换位置
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    // 有元素交换，所以不是有序，标记变为false
                    flag = false;
                    // 最后一次交换元素的位置
                    lastSwapIndex = j;
                }
                System.out.println(Arrays.toString(array));
            }

            // 把最后一次交换元素的位置赋值给无序数组的边界
            arrBoundary = lastSwapIndex;
            // 说明上面内层for循环中，没有交换任何元素，直接跳出外层循环
            if (flag) {
                break;
            }
        }
    }
}
