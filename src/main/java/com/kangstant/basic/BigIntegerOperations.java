package com.kangstant.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 大数加法
 */
public class BigIntegerOperations {

    // 最大位数位1000000
    private final static int MAX_SIZE = 1000010;

    // 大数加法
    public static List<Integer> add(List<Integer> A, List<Integer> B) {

        List<Integer> result = new ArrayList<>();

        int t = 0; // 进位

        for (int i = 0; i < A.size() || i < B.size(); i++) {
            if (i < A.size()) t += A.get(i);
            if (i < B.size()) t += B.get(i);
            result.add(t % 10);
            t = t / 10;
        }

        if (t != 0) result.add(t);

        return result;
    }

    // 大数减法
    public static List<Integer> sub(List<Integer> A, List<Integer> B) {
        if (!cmp(A, B)) {
            return sub(B, A);
        }

        List<Integer> C = new ArrayList<>();
        int t = 0;
        for (int i = 0; i < A.size(); i++) {
            //这里应该是A.get(i) - B.get(i) - t ，因为可能B为零，所以需要判断一下是不是存在
            t = A.get(i) - t;
            if (i < B.size()) t -= B.get(i);
            C.add((t + 10) % 10);

            if (t < 0) t = 1;
            else t = 0;
        }
        //删除指定下标下面的值
        while (C.size() > 1 && C.get(C.size() - 1) == 0) C.remove(C.size() - 1);

        return C;
    }

    public static boolean cmp(List<Integer> A, List<Integer> B) {
        if (A.size() != B.size()) return A.size() > B.size();
       /* if(A.size() >= B.size()){
            return true;
        }else{
            return false;
        }
        */
        for (int i = A.size() - 1; i >= 0; i--) {
            if (A.get(i) != B.get(i)) {
                return A.get(i) > B.get(i);
            }
        }
        return true;
    }

    // 大数乘法
    public static List<Integer> mul(List<Integer> A, int b) {
        List<Integer> C = new ArrayList<>();
        int t = 0;
        for (int i = 0; i < A.size() || t != 0; i++) {
            if (i < A.size()) t += A.get(i) * b;
            C.add(t % 10);
            t /= 10;
        }
        while (C.size() > 1 && C.get(C.size() - 1) == 0) C.remove(C.size() - 1);

        return C;
    }

    // 大数除法
    public static List<Integer> div(List<Integer> A,int b){
        List<Integer> C = new ArrayList<>();

        int r = 0;
        for(int i = A.size() - 1 ;i >= 0; i --){
            r = r * 10 + A.get(i);
            C.add(r / b);
            r %= b;
        }
        Collections.reverse(C);
        while(C.size() > 1 && C.get(C.size() - 1) == 0) C.remove(C.size() - 1);

        C.add(r);
        return C;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String aStr = in.readLine();
        String bStr = in.readLine();

        // 开两个数组
        List<Integer> A = new ArrayList<>(aStr.length());
        List<Integer> B = new ArrayList<>(bStr.length());

        for (int i = aStr.length() - 1; i >= 0; i--) {
            A.add(aStr.charAt(i) - '0');
        }


        for (int i = bStr.length() - 1; i >= 0; i--) {
            B.add(bStr.charAt(i) - '0');
        }

        List<Integer> resAdd = new ArrayList<>();
        resAdd = add(A, B);

        System.out.printf("Add:==============");
        for (int i = resAdd.size() - 1; i >= 0; i--) {
            System.out.printf(String.valueOf(resAdd.get(i)));
        }
    }
}
