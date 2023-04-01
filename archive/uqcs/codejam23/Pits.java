package sol;

import com.github.nathanwn.jcp.io.InputReader;
import java.io.PrintWriter;

public class Pits {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] g = new int[n + 2][m + 2];
        for (int i = 0; i <= n + 1; i++) {
            for (int j = 0; j <= m + 1; j++) {
                g[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                g[i][j] = in.nextInt();
            }
        }

        int res = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (g[i][j] < g[i - 1][j]
                && g[i][j] < g[i + 1][j]
                && g[i][j] < g[i][j - 1]
                && g[i][j] < g[i][j + 1]) {
                    res++;
                }
            }
        }

        out.println(res);
    }
}
