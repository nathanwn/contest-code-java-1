package sol;

import com.github.nathanwn.jcp.io.InputReader;
import java.io.PrintWriter;

public class Vrbik {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] real = new int[n];
        int[] min = new int[n];
        int[] max = new int[n];
        for (int i = 0; i < n; i++) {
            real[i] = in.nextInt();
            min[i] = in.nextInt();
            max[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (min[i] <= real[i] && real[i] <= max[i]) {
                out.print(real[i] + " ");
            } else {
                out.print("-1 ");
            }
        }
    }
}
