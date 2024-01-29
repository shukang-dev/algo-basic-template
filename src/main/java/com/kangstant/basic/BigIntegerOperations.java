package com.kangstant.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 大数加法
 */
public class BigIntegerOperations {
    // 大数加法
    public static List<Integer> add(List<Integer> A, List<Integer> B) {
        List<Integer> result = new ArrayList<>();
        int carry = 0;

        for (int i = 0; i < Math.max(A.size(), B.size()) || carry > 0; i++) {
            int sum = carry;
            if (i < A.size()) sum += A.get(i);
            if (i < B.size()) sum += B.get(i);

            result.add(sum % 10);
            carry = sum / 10;
        }

        return result;
    }

    // 大数减法
    public static List<Integer> subtract(List<Integer> A, List<Integer> B) {
        List<Integer> result = new ArrayList<>();
        int borrow = 0;

        for (int i = 0; i < A.size() || borrow > 0; i++) {
            int diff = borrow;
            if (i < A.size()) diff += A.get(i);
            if (i < B.size()) diff -= B.get(i);

            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            result.add(diff);
        }

        // 移除前导零
        while (result.size() > 1 && result.get(result.size() - 1) == 0) {
            result.remove(result.size() - 1);
        }

        return result;
    }

    // 大数乘法
    public static List<Integer> multiply(List<Integer> A, List<Integer> B) {
        List<Integer> result = new ArrayList<>(Collections.nCopies(A.size() + B.size(), 0));

        for (int i = 0; i < A.size(); i++) {
            int carry = 0;
            for (int j = 0; j < B.size() || carry > 0; j++) {
                int product = result.get(i + j) + carry + A.get(i) * (j < B.size() ? B.get(j) : 0);
                result.set(i + j, product % 10);
                carry = product / 10;
            }
        }

        // 移除前导零
        while (result.size() > 1 && result.get(result.size() - 1) == 0) {
            result.remove(result.size() - 1);
        }

        return result;
    }

    // 大数除法
    public static List<Integer> divide(List<Integer> A, int divisor) {
        List<Integer> result = new ArrayList<>();
        int remainder = 0;

        for (int i = A.size() - 1; i >= 0; i--) {
            int currentDigit = A.get(i) + remainder * 10;
            result.add(0, currentDigit / divisor);
            remainder = currentDigit % divisor;
        }

        // 移除前导零
        while (result.size() > 1 && result.get(0) == 0) {
            result.remove(0);
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(9);
        A.add(9);
        A.add(9);

        List<Integer> B = new ArrayList<>();
        B.add(2);
        B.add(1);

        // 加法
        List<Integer> sum = add(A, B);
        System.out.println("Sum: " + sum);

        // 减法
        List<Integer> difference = subtract(A, B);
        System.out.println("Difference: " + difference);

        // 乘法
        List<Integer> product = multiply(A, B);
        System.out.println("Product: " + product);

        // 除法
        List<Integer> quotient = divide(A, 3);
        System.out.println("Quotient: " + quotient);
    }
}
