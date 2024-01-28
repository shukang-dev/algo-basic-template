package com.kangstant.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSort {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        String[] arr = in.readLine().split(" ");
        int[] q = new int[n];
        for(int i=0; i<n; i++) {
            q[i]=Integer.parseInt(arr[i]);
        }

        mergeSort(q, 0, n-1);
        for (int i = 0; i < n; i++) {
            System.out.print(q[i] + " ");
        }


    }

    public static void mergeSort(int[] q, int l, int r) {
        if (l >= r) return;

        int mid = l + r >> 1;
        mergeSort(q, l, mid);
        mergeSort(q, mid + 1, r);

        int k = 0, i = l, j = mid + 1;

        int[] temp = new int[r-l+1];

        while (i <= mid && j <= r) {
            if (q[i] <= q[j]) {
                temp[k++] = q[i++];
            } else {
                temp[k++] = q[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = q[i++];
        }

        while (j <= r) {
            temp[k++] = q[j++];
        }

        for (i = l, j = 0; i <= r; i++, j++) {
            q[i] = temp[j];
        }
    }
}