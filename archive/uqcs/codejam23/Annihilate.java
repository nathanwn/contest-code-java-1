package sol;

import com.github.nathanwn.jcp.io.InputReader;
import java.io.PrintWriter;
import java.util.*;

public class Annihilate {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        Point3D[] points = new Point3D[n];
        for (int i = 0; i < n; i++) {
            double x = in.nextDouble();
            double y = in.nextDouble();
            double z = in.nextDouble();
            points[i] = new Point3D(x, y, z);
        }
        double[][] ds = new double[n][n];
        ArrayList<Distance> distances = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double d = points[i].distance(points[j]);
                ds[i][j] = d;
                distances.add(new Distance(i, j, d));
            }
        }
        Collections.sort(distances, new Comparator<Distance>() {
            @Override
            public int compare(Distance a, Distance b) {
                return Double.compare(a.d, b.d);
            }
        });
        HashSet<Integer> exists = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            exists.add(i);
        }
        for (Distance distance : distances) {
            if (!exists.contains(distance.i) || !exists.contains(distance.j)) {
                continue;
            }
            exists.remove(distance.i);
            exists.remove(distance.j);
        }
        if (exists.size() != 1) {
            throw new RuntimeException();
        }
        for (Integer x : exists) {
            out.println(x);
        }
    }

    class Distance {
        int i;
        int j;
        double d;

        public Distance(int i, int j, double d) {
            this.i = i;
            this.j = j;
            this.d = d;
        }
    }

    class Point3D {
        double x;
        double y;
        double z;

        Point3D(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        double distance(Point3D other) {
            return Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2) + Math.pow(z - other.z, 2));
        }
    }
}
