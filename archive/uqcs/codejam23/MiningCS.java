package sol;

import com.github.nathanwn.jcp.io.InputReader;
import java.io.PrintWriter;

public class MiningCS {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String s = in.next().toLowerCase();
        for (char c : s.toCharArray()) {
            if (c == 'r') {
                out.println("right");
            } else if (c == 'l') {
                out.println("left");
            } else if (c == 's') {
                out.println("straight");
            } else if (c == 'j') {
                out.println("jump");
            } else {
                out.println("Aaaaah!");
            }
        }
    }
}
