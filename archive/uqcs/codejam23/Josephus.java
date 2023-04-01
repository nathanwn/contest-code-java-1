package sol;

import com.github.nathanwn.jcp.io.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Josephus {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = i;
        }
        int cntRemoved = 0;
        int counter = 0;
        boolean[] removed = new boolean[n + 1];
        Arrays.fill(removed, false);
        int p = 0;
        while (cntRemoved < n - 1) {
            p++;
            if (p > n) p = 1;
            if (removed[p]) continue;
            counter++;
            if (counter == k) {
                removed[p] = true;
                cntRemoved++;
                counter = 0;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!removed[i]) {
                out.println(i);
            }
        }
    }
}
