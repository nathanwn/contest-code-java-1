package sol;

import com.github.nathanwn.jcp.io.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class AppleThatIAmGoingToEat {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        if (check(in)) {
            out.println("apple that I am going to eat");
        }
    }

    boolean check(InputReader in) {
        char[] apple = "apple".toCharArray();
        int p = 0;
        StringBuilder sb = new StringBuilder();
        while (in.hasNext()) {
            sb.append(in.next().toLowerCase());
            sb.append(" ");
        }
        char[] s = sb.toString().toCharArray();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == apple[p]) {
                p++;
                if (p == apple.length) {
                    return true;
                }
            }
        }
        return false;
    }
}
