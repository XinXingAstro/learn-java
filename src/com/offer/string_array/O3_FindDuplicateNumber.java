package com.offer.string_array;

/**
 * 面试题3：找出数组中的重复数字
 * 问题：
 * 1）数组的长度是多少？
 * 2）数组中数据的范围有没有规定？
 * 3）数组中有多少重复数字？
 * 4）重复数字重复了几次？
 *
 * 答：
 * 1）数组长度为n
 * 2）所有数字在0～n-1的范围内！！！
 * 3）数组中不确定有多少重复数字
 * 4）不知道数字重复了几次
 * 5）需要找出多少重复数字，1个？n个？
 *
 * 算法：
 * 1）可以先把数组排序，然后找到第一个重复数字。 时：O(nlogn) 空：O(1)。
 * 2）可以利用Hash表统计每个数组出现的次数。 时：O(n) 空：O(n)。
 * 3）上面两种算法都没有很好的利用条件2）即数组内所有数字都在0～n-1范围内，
 * 如果所有数字都在0～n-1范围内，那么n个数如果没有重复数字，则从小到大排序
 * 后n个数字的数值正好和下标相等。我们扫描数组的每个数，看其大小是否和所在
 * 位置下表相等，若相等则继续扫描后面的数，若不等我们拿它和以它数值为下标的
 * 位置的数做比较，如果两数不等，则交换两个数，继续扫描，若相等则找到重复数字，
 * 将其返回。时：O(n) 空：O(1)。
 *
 * 测试用例：
 * 1）功能测试：数组中包含n个数，并且有0、1、2个重复数字。
 * 2）无效输入：数组长度为0、1，数组变量为null。（和面试官确定怎样进行错误输入处理）
 *
 * 写代码，检查代码，提交
 */
public class O3_FindDuplicateNumber {

    public int findDuplicateNumbers(int[] a) {
        if (a == null || a.length <= 1) return -1; //-1代表错误输入

        for (int i = 0; i < a.length; i++) {
            if (a[i] != i) {
                if (a[i] != a[a[i]]) {
                    swap(a, i, a[i]);
                    i--;
                } else return a[i];
            }
        }
        return -1;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        //测试用例
        int[] a1 = {};
        int[] a2 = null;
        int[] a3 = {0};
        int[] a4 = {3, 2, 1, 4, 1};
        int[] a5 = {6, 4, 7, 6, 6, 2, 7, 1, 9, 0};

        O3_FindDuplicateNumber f1 = new O3_FindDuplicateNumber();
        System.out.println(f1.findDuplicateNumbers(a1));
        System.out.println(f1.findDuplicateNumbers(a2));
        System.out.println(f1.findDuplicateNumbers(a3));
        System.out.println(f1.findDuplicateNumbers(a4));
        System.out.println(f1.findDuplicateNumbers(a5));
    }
}
