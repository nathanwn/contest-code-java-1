package sol;

import com.github.nathanwn.jcp.io.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class AbundantNumbers {
    final int C = (int) 1e5 + 1;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int[] divSum = new int[C + 7];

        Arrays.fill(divSum, 1);

        for (int i = 2; i <= C; i++) {
            for (int j = i * 2; j <= C; j += i) {
                divSum[j] += i;
            }
        }

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            if (divSum[x] > x) {
                out.print(x + " ");
            }
        }
        out.println();

    }
}
