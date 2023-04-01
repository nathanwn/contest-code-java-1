package sol;

import com.github.nathanwn.jcp.io.InputReader;
import java.io.PrintWriter;

public class Subarray {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        long best = Long.MIN_VALUE;
        long cur = a[0];
        for (int i = 1; i < n; i++) {
            cur = Math.max(a[i], cur + a[i]);
            best = Math.max(best, cur);
        }
        out.println(best);
    }
}
