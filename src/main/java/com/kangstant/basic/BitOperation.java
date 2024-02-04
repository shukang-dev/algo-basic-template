package com.kangstant.basic;

/**
 * @author spencer.huang@nio.com
 * @date 2024/2/4 16:55
 * 位运算
 */

public class BitOperation {

    /*
        计算二进制中 1 的个数
     */
    private static int countDigitOne(int x) {
        int count = 0;
        for (int i = x; i != 0; i -= (i & -i)) {
            count++;
        }
        return count;
    }
}
