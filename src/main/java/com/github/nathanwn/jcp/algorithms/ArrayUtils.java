package com.github.nathanwn.jcp.algorithms;

import java.util.Random;

public class ArrayUtils {
    public static void iota(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
    }

    public static void randomShuffle(Random random, int[] a) {
        // Fisher-Yates shuffle
        for (int i = a.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }
}
