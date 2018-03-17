package com.offer.math;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 找出数据流中的中位数
 *
 */
public class O41_MedianNumberInDataFlow {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    int count = 0;
    public void Insert(Integer num) {
        //当count是偶数时，数据插入最小堆
        //当count是奇数时，数据插入最大堆
        if ((count & 1) == 0) {
            if (maxHeap.size() != 0 && num < maxHeap.peek()) {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(num);
                count++;
            } else {
                minHeap.offer(num);
                count++;
            }
        } else {
            if (num > minHeap.peek()) {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
                count++;
            } else {
                maxHeap.offer(num);
                count++;
            }
        }
    }

    public Double GetMedian() {
        if ((count & 1) == 0) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return (double)minHeap.peek();
        }
    }

    public static void main(String[] args) {
        O41_MedianNumberInDataFlow test = new O41_MedianNumberInDataFlow();
        test.Insert(5);
        System.out.print(test.GetMedian());
        test.Insert(2);
        System.out.print(test.GetMedian());
        test.Insert(3);
        System.out.print(test.GetMedian());
        test.Insert(4);
        System.out.print(test.GetMedian());
        test.Insert(1);
        System.out.print(test.GetMedian());
        test.Insert(6);
        System.out.print(test.GetMedian());
        test.Insert(7);
        System.out.print(test.GetMedian());
        test.Insert(0);
        System.out.print(test.GetMedian());
        test.Insert(8);
        System.out.print(test.GetMedian());
    }
}
