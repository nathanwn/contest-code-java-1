package sol;

import com.github.nathanwn.jcp.io.InputReader;
import java.io.PrintWriter;

public class TwentyOne {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int count = 0;
        while (in.hasNext()) {
            String s = in.next();
            if (s.equals("A") || s.equals("T")  || s.equals("J") || s.equals("Q") || s.equals("K")) {
                count -= 1;
            } else {
                int v = Integer.parseInt(s);
                if (v >= 2 && v <= 6) {
                    count += 1;
                }
            }
        }
        out.println(count);
    }
}
