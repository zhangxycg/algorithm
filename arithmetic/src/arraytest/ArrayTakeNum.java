package arraytest;

import java.util.Arrays;

/**
 * @Description:定义一个整数数组，找出连续3个元素之和是最大的，并输出这三个元素。
 * 示例：
 *      输入：2 ，-6 ，3，-9 ，5，-10， 8
 *      输出： 3,-9,15
 * @Author: zhangxy
 * @Date: Created in 13:05 2019/9/25
 * @Modified By:
 */
public class ArrayTakeNum {

    public static void main(String[] args) {
        int[] array = {2, -6, 3, -9, 15, -10, 8};
        System.out.println("定义的整数数组为： " + Arrays.toString(array));
        //定义一个数组用于存储连续三个数字的和
        int[] temp = new int[4];
        for (int i = 0; i < 4; i++) {
            int s = array[i] + array[i + 1] + array[i + 2];
            temp[i] = s;
        }
        int max = temp[0];
        int index = 0;
        for (int i = 0; i < temp.length; i++) {
            if (max < temp[i]) {
                max = temp[i];
                index = i;
            }
        }
        System.out.println("连续3个元素之和是最大的三个数分别是：" +
                array[index] + "," + array[index + 1] + "," + array[index + 2]);
    }
}

