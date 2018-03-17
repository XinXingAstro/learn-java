package com.offer.stack_queue;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里的最大值
 * 算法：找队列最大值算法
 * 要想得到一个队列queue（双端或单端）的最大值，需要用到一个双端队列deque，该队列头部永远存放当前队列最大值
 * 当一个数从尾部（或头部）进入queue时，若该数比deque尾部数字大，则先将deque尾部数字弹出，直到前面数字比该数大
 * 或者deque为空时将该数从尾部压入deque，
 * 当queue从头部弹出一个数时，若该数的下标和deque头部数字下标相同（即两个是同一个元素）则从deque中也将该数从头部弹出
 * 如果给定一个数组，一般压如deque中的是元素位于数组中的下标
 */
public class O59_1_MaxInSlideWindow {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (num == null || num.length == 0 || size == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<Integer> max = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            while (max.size() != 0 && num[i] > num[max.peekLast()]) {
                max.pollLast();
            }
            max.offerLast(i); //max队列中存如的是元素在数组中的下标
        }
        for (int i = size; i < num.length; i++) {
            result.add(num[max.peekFirst()]);
            while (max.size() != 0 && num[i] > num[max.peekLast()]) {
                max.pollLast();
            }
            if (max.size() != 0 && (i - max.peekFirst()) >= size) {
                max.pollFirst();
            }
            max.offerLast(i);
        }
        result.add(num[max.peekFirst()]);
        return result;
    }

    public static void main(String[] args) {
        int[] num = {2,3,4,2,6,2,5,1};
        O59_1_MaxInSlideWindow test = new O59_1_MaxInSlideWindow();
        System.out.print(test.maxInWindows(num, 3));
    }
}
