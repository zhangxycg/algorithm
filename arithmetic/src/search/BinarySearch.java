package search;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @Description: 二分法查找（折半查找），找指定数值所在的位置
 * @Author: zhangxy
 * @Date: Created in 14:03 2019/9/27
 * @Modified By:
 */
public class BinarySearch {

    public static void main(String[] args) {

        // 生成一个随机数组
        int[] array = suiji();
        // 对随机数组排序
        Arrays.sort(array);
        System.out.println("产生的随机数组为： " + Arrays.toString(array));

        System.out.println("要进行查找的值： ");
        Scanner input = new Scanner(System.in);
        // 进行查找的目标值
        int aim = input.nextInt();

        // 使用二分法查找
        int index = binarySearch(array, aim);
        System.out.println("查找的值的索引位置： " + index);

    }

    /**
     * 生成一个随机数组
     *
     * @return 返回值，返回一个随机数组
     */
    private static int[] suiji() {
        // random.nextInt(n)+m  返回m到m+n-1之间的随机数
        int n = new Random().nextInt(6) + 5;
        int[] array = new int[n];
        // 循环遍历为数组赋值
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(100);
        }
        return array;
    }

    /**
     * 二分法查找
     *
     * @param array 要查找的数组
     * @param aim 要查找的值
     * @return 返回值，成功返回索引，失败返回-1
     */
    private static int binarySearch(int[] array, int aim) {
        // 数组最小索引值
        int low = 0;
        // 数组最大索引值
        int right = array.length - 1;
        int mid;
        while (low <= right) {
            mid = (low + right) / 2;
            // 若查找数值比中间值小，则以整个查找范围的前半部分作为新的查找范围
            if (aim < array[mid]) {
                right = mid - 1;
                // 若查找数值比中间值大，则以整个查找范围的后半部分作为新的查找范围
            } else if (aim > array[mid]) {
                low = mid + 1;
                // 若查找数据与中间元素值正好相等，则放回中间元素值的索引
            } else {
                return mid;
            }
        }
        return -1;
    }
}
