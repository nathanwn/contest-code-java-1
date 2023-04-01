package sol;

import com.github.nathanwn.jcp.io.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Planets {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int planets = in.nextInt();
        int cats = in.nextInt();
        int[][] m = new int[planets][cats];
        for (int i = 0; i < planets; i++) {
            for (int j = 0; j < cats; j++) {
                m[i][j] = in.nextInt();
            }
        }
        int[] bestCatVal = new int[planets];
        for (int i = 0; i < planets; i++) {
            for (int j = 0; j < cats; j++) {
                bestCatVal[i] = Math.max(bestCatVal[i], m[i][j]);
            }
        }

        ArrayList<ArrayList<Integer>> bestCats = new ArrayList<>();
        for (int i = 0; i < planets; i++) {
            bestCats.add(new ArrayList<>());
        }
        for (int i = 0; i < planets; i++) {
            for (int j = 0; j < cats; j++) {
                if (m[i][j] == bestCatVal[i]) {
                    bestCats.get(i).add(j);
                }
            }
        }
        double[] res = new double[cats];
        for (int i = 0; i < planets; i++) {
            for (int j : bestCats.get(i)) {
                res[j] += (double) m[i][j] / bestCats.get(i).size();
            }
        }
        for (int j = 0; j < cats; j++) {
            out.printf("%.2f\n", res[j]);
        }
    }
}
