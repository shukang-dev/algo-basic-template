package com.kangstant.basic;

/**
 * 整数二分
 */
public class BinarySearch {

    // 先写一个 mid，再写一个 check 函数，在判断 mid 是否需要+1

    /**
     * 模板 1: 区间[l, r]被划分为[l,mid],[mid+1, r]时使用
     */
    public static int binarySearch1(int l, int r) {
        while (l < r) {
            int mid = l + r >> 1;

            if (check(mid)) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        return l; // 此时 l=r，所以return l 或者 r 都行
    }


    /**
     * 模板 2：区间[l, r]被划分为[l, mid-1],[mid, r]时使用
     */
    public static int binarySearch2(int l, int r) {
        while (l < r) {
            int mid = l + r + 1 >> 1;

            if (check(mid)) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }

        return l;
    }

    public static boolean check(int mid) {
        // 判断逻辑，判断 mid 是否满足性质
        return true;
    }


}
