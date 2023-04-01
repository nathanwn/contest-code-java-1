package sol;



import com.github.nathanwn.jcp.io.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Trampoline {
    int n;
    int m;
    int[][] g;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        g = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] = in.nextInt();
            }
        }
        boolean[][] visited = new boolean[n][m];
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = false;
                dist[i][j] = (int) 1e9;
            }
        }
        Queue<Point> q = new LinkedList<>();
        Point s = new Point(0, 0);
        q.add(s);
        visited[s.x][s.y] = true;
        dist[s.x][s.y] = 0;

        while (!q.isEmpty()) {
            Point u = q.remove();
            if (u.x == n - 1 && u.y == m - 1) {
                out.println(dist[u.x][u.y]);
                return;
            }

            for (Point v : u.moves()) {
                if (visited[v.x][v.y]) continue;
                dist[v.x][v.y] = dist[u.x][u.y] + 1;
                visited[v.x][v.y] = true;
                q.add(v);
            }
        }

        throw new RuntimeException();
    }

    class Point implements Comparable<Point> {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        ArrayList<Point> moves() {
            ArrayList<Point> moves = new ArrayList<>();
            Point p1 = new Point(x - g[x][y], y);
            if (p1.within()) moves.add(p1);
            Point p2 = new Point(x + g[x][y], y);
            if (p2.within()) moves.add(p2);
            Point p3 = new Point(x, y - g[x][y]);
            if (p3.within()) moves.add(p3);
            Point p4 = new Point(x, y + g[x][y]);
            if (p4.within()) moves.add(p4);
            return moves;
        }

        boolean within() {
            return 0 <= x && x < n && 0 <= y && y < m;
        }

        @Override
        public int compareTo(Point other) {
            if (x == other.x)
                return Integer.compare(y, other.y);
            return Integer.compare(x, other.x);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
