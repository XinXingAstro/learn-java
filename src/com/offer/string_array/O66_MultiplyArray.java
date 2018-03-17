package com.offer.string_array;

/**
 * 给定一个数组A[0,1,...,n-1]，请构建一个数组B[0,1,...,n-1]，
 * 其中B中的元素B[i] = A[0] * A[1] * ... * A[i-1] * A[i+1] * ... * A[n-1]
 * 不能使用除法。
 * 算法：
 * B可以看成如下所示数组，先从上倒下逐个累加左边部分，存到数组里
 * 然后再从下到上逐个计算出Bi
 * B0    1   A1  A2   ...   An-2  An-1
 * B1    A0  1   A2   ...   An-2  An-1
 * B2    A0  A1  1    ...   An-2  An-1
 * ...   A0  A1  ...   1    An-2  An-1
 * Bn-2  A0  A1  ...  An-3    1   An-1
 * Bn-1  A0  A1  ...  An-3  An-2   1
 */
public class O66_MultiplyArray {
    public int[] multiply(int[] A){
        if (A == null || A.length < 1) {
            return null;
        }
        int length = A.length;
        int[] B = new int[length];
        B[0] = 1;
        for (int i = 1; i < length; i++) {
            B[i] = B[i-1] * A[i-1];
        }
        int D = 1;
        for (int i = length - 2; i >= 0; i--) {
            D = D * A[i + 1];
            B[i] *= D;
        }
        return B;
    }
    public static void main(String[] args) {
        O66_MultiplyArray test = new O66_MultiplyArray();
        int[] A = {1,2,3,4,5};
        System.out.print(test.multiply(A));
    }
}
