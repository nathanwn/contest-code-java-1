package test.battle.yosupo.Unionfind;

import com.github.nathanwn.jcp.io.InputReader;
import com.github.nathanwn.jcp.structures.Dsu;
import java.io.PrintWriter;

public class Unionfind {

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int q = in.nextInt();
        Dsu dsu = new Dsu(n);

        for (int j = 0; j < q; j++) {
            int t = in.nextInt();
            int u = in.nextInt();
            int v = in.nextInt();
            if (t == 0) {
                dsu.merge(u, v);
            } else {
                if (dsu.find(u) == dsu.find(v)) {
                    out.println(1);
                } else {
                    out.println(0);
                }
            }
        }
    }
}
