package test.battle.self.TestPermutations;

import com.github.nathanwn.jcp.io.InputReader;
import com.github.nathanwn.jcp.iterators.Permutations;
import java.io.PrintWriter;

public class TestPermutations {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        Permutations ps = new Permutations(n);
        int cnt = 0;
        for (int[] p : ps) {
            cnt++;
        }
        out.println(cnt);
    }
}
