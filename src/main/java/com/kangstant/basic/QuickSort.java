package com.kangstant.basic;

import java.util.Scanner;

/**
 * 对边界小结下：
 *
 * quickSort(q, l, j);
 * quickSort(q, j + 1, r);
 * 或
 *
 * quickSort(q, l, i - 1);
 * quickSort(q, i, r);
 * 是因为对于第一次处理后的数组，索引i左侧的数字都是小于等于x，但不包括q[i]。索引i右侧的数字都是大于等于x，包括q[i]。故区间分为[l,i-1]和[i,r]。
 * 同理，对于第一次处理后的数组，索引j左侧的数字都是小于等于x，包括q[j]。索引j右侧的数字都是大于等于x，不包括q[j]。故区间分为[l,j]和[j+1,r]。
 *
 * 再对x位置小结：
 *
 * 如果区间取[l,i-1]和[i,r]这种，那么x不应该取左边界(l、(l+r)/2)。
 * 应取 x = q[r]; x = q[(l+r+1)/2];
 *
 * 如果区间取[l,j]和[j+1,r]这种，那么x不应该取右边界(如r、(l+r+1)/2)。
 * 应取 x = q[l]; x = q[(l+r)/2];
 *
 * 自己选择其中一种即可。
 */

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] q = new int[n];
        for (int i = 0; i < n; i++) {
            q[i] = sc.nextInt();
        }

        quickSort(q, 0, n-1);
        for (int i = 0; i < n; i++) {
            System.out.println(q[i] + " ");
        }
    }

    public static void quickSort(int[] q, int l, int r) {
        if (l >= r) return;

        int x = q[(l + r) / 2];
        int i = l - 1;
        int j = r + 1;

        while (i < j) {
            while (q[++i] < x) {};
            while (q[--j] > x) {};
            if (i < j) {
                int t = q[i];
                q[i] = q[j];
                q[j] = t;
            }
        }
        quickSort(q, l, j);
        quickSort(q, j+1, r);
    }
}
