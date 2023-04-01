package sol;

import com.github.nathanwn.jcp.io.InputReader;
import java.io.PrintWriter;

public class Tiles {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        final int N = (int) 1e4;
        int n = in.nextInt();
        boolean[][] b = new boolean[2 * N][2 * N];
        int x0 = in.nextInt();
        int y0 = in.nextInt();
        b[N][N] = true;
        int score = 1;

        for (int i = 1; i < n; i++) {
            int x = in.nextInt() - x0 + N;
            int y = in.nextInt() - y0 + N;
            b[x][y] = true;
            int left = 0;
            int right = 0;
            int up = 0;
            int down = 0;
            for (int j = y - 1; j >= 0; j--) {
                if (!b[x][j]) break;
                left++;
            }
            for (int j = y + 1; ; j++) {
                if (!b[x][j]) break;
                right++;
            }
            for (int j = x - 1; j >= 0; j--) {
                if (!b[j][y]) break;
                up++;
            }

            for (int j = x + 1; ; j++) {
                if (!b[j][y]) break;
                down++;
            }
            score += 1 + left + right + up + down;
            if (left + right > 0 && up + down > 0) score += 1;
        }
        out.println(score);
    }
}
