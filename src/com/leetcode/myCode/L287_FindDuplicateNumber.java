package com.leetcode.myCode;

/**
 * leetcode 287. Find the Duplicate Number
 *
 */
public class L287_FindDuplicateNumber {
    /**
     * 龟兔赛跑算法
     * 该算法要求数组容量必须比元素取值范围大至少1
     * 由于已知测试数组中包含元素0，所以为了避免出现闭环，将链表中每个节点
     * 指向下一节点的值+1（避免指向0节点）
     * @param nums
     * @return
     */
    public static int findDuplicate_1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }

        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow + 1];
            fast = nums[nums[fast + 1] + 1];
        } while (slow != fast);
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow + 1];
            fast = nums[fast + 1];
        }

        return slow;
    }


    /**
     * 以元素值对应数组下标
     * 该算法需要修改数组，不满足Read-only条件
     * 同样适用于O3
     * @param nums
     * @return
     */
    public static int findDuplicate_2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }

        int i = 0;
        while (i != (nums.length - 1)) {
            if (nums[i] != i) {
                if (nums[i] != nums[nums[i]]) {
                    int temp = nums[i];
                    nums[i] = nums[temp];
                    nums[temp] = temp;
                } else return nums[i];
            } else i++;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] a = {0,3,4,5,3,7,7,1,0};
//        System.out.println(L287_FindDuplicateNumber.findDuplicate_1(a));
        System.out.println(L287_FindDuplicateNumber.findDuplicate_2(a));
    }
}
