package sol;

import com.github.nathanwn.jcp.io.InputReader;
import java.io.PrintWriter;

public class UnidentifiedOnLine1 {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String s = in.next();
        out.println(solve(s));

    }

    private int solve(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '{') {
                cnt++;
            } else {
                if (cnt == 0) {
                    return 0;
                }
                cnt--;
            }
        }
        if (cnt > 0) return 0;
        return 1;
    }
}
