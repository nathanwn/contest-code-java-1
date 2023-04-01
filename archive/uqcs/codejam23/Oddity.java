package sol;

import com.github.nathanwn.jcp.io.InputReader;
import java.io.PrintWriter;
import java.util.*;

public class Oddity {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] count = new int[256];
        Arrays.fill(count, 0);
        boolean[] already = new boolean[256];

        for (int i = 0; i < n; i++) {
            String s = in.next();
            Arrays.fill(already, false);
            HashSet<Character> set = new HashSet<>();
            for (char c : s.toCharArray()) {
                if (already[c]) continue;
                count[c]++;
                already[c] = true;
            }
        }
        ArrayList<Character> odds = new ArrayList<>();
        for (char c = 0; c < 256; c++) {
            if (count[c] % 2 == 1) {
                odds.add(c);
            }
        }
        Collections.sort(odds);
        for (char c : odds) {
            out.print(c);
        }
        out.println();
    }
}
