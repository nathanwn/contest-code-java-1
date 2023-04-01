package com.github.nathanwn.jcp.iterators;

import com.github.nathanwn.jcp.algorithms.ArrayUtils;
import java.util.Arrays;
import java.util.Iterator;

public class Permutations implements Iterable<int[]> {
    private Iterator<int[]> iterator;

    public Permutations(int n) {
        this.iterator = new PermutationIterator(n);
    }

    @Override
    public Iterator<int[]> iterator() {
        return this.iterator;
    }
}

class PermutationIterator implements Iterator<int[]> {
    int n;
    private int[] a;

    PermutationIterator(int n) {
        this.n = n;
    }

    @Override
    public boolean hasNext() {
        if (a == null) {
            return true;
        }
        for (int i = a.length - 2; i > -1; i--) {
            if (a[i] < a[i + 1]) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int[] next() {
        if (a == null) {
            a = new int[n];
            ArrayUtils.iota(a, n);
            return a;
        }

        // Find descendingSuffixStop such that
        // a[descendingSuffixStop + 1] is the longest descending suffix of a.
        int descendingSuffixStop = -1;
        for (int i = a.length - 2; i > -1; i--) {
            if (a[i] < a[i + 1]) {
                descendingSuffixStop = i;
                break;
            }
        }

        int curLeadingValueIndex = descendingSuffixStop;
        int nextLeadingValueIndex = -1;
        int nextLeadingValue = Integer.MAX_VALUE;

        for (int i = curLeadingValueIndex + 1; i < a.length; i++) {
            if (a[i] > a[curLeadingValueIndex] && a[i] < nextLeadingValue) {
                nextLeadingValueIndex = i;
                nextLeadingValue = a[nextLeadingValueIndex];
            }
        }

        if (nextLeadingValue == -1) {
            throw new RuntimeException();
        }

        int tmp = a[curLeadingValueIndex];
        a[curLeadingValueIndex] = a[nextLeadingValueIndex];
        a[nextLeadingValueIndex] = tmp;

        Arrays.sort(a, curLeadingValueIndex + 1, a.length);

        return a;
    }
}
