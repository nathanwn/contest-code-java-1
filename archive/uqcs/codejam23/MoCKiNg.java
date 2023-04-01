package sol;

import com.github.nathanwn.jcp.io.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MoCKiNg {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = in.nextInt();
        }
        StringBuilder sb = new StringBuilder();
        while (in.hasNext()) {
            sb.append(in.next());
            sb.append(" ");
        }
        char[] s = sb.toString().toCharArray();
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < d.length; j++) {
                if (i % d[j] == 0) {
                    if (s[i] >= 'A' && s[i] <= 'Z') {
                        s[i] += 'a' - 'A';
                        break;
                    } else if (s[i] >= 'a' && s[i] <= 'z') {
                        s[i] += 'A' - 'a';
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < s.length; i++) {
            out.print(s[i]);
        }
        out.println();
    }
}
