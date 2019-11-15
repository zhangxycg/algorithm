package search;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static java.util.Arrays.binarySearch;

/**
 * @Description:
 * @Author: zhangxy
 * @Date: Created in
 * @Modified By:
 */
public class BinarySearch2 {
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
        int index = binarySearch(array, aim, 0, array.length - 1);
        System.out.println("查找的值的索引位置： " + index);
    }

    /**
     * 生成一个随机数组
     *
     * @return 返回值，返回一个随机数组
     */
    private static int[] suiji() {
        // Random.nextInt(n)+m  返回m到m+n-1之间的随机数
        int n = new Random().nextInt(6) + 5;
        int[] array = new int[n];
        // 循环遍历为数组赋值
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(100);
        }
        return array;
    }

    /**
     * 二分法查找 ---递归的方式
     *
     * @param array 要查找的数组
     * @param aim   要查找的值
     * @param left  左边最小值
     * @param right 右边最大值
     * @return 返回值，成功返回索引，失败返回-1
     */
    private static int binarySearch(int[] array, int aim, int left, int right) {
        if (aim < array[left] || aim > array[right]) {
            return -1;
        }
        // 找中间值
        int mid = (left + right) / 2;
        if (array[mid] == aim) {
            return mid;
        } else if (array[mid] > aim) {
            //如果中间值大于要找的值则从左边一半继续递归
            return binarySearch(array, aim, left, mid - 1);
        } else {
            //如果中间值小于要找的值则从右边一半继续递归
            return binarySearch(array, aim, mid + 1, array.length-1);
        }
    }
}

