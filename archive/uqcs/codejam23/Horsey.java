package sol;

import com.github.nathanwn.jcp.io.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Horsey {
    int[][] knightMoves = new int[][]{
            {-2, -1},
            {-2, 1},
            {-1, -2},
            {-1, 2},
            {1, -2},
            {1, 2},
            {2, -1},
            {2, 1},
    };

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int sx = in.nextInt();
        int sy = in.nextInt();
        int tx = in.nextInt();
        int ty = in.nextInt();
        Point s = new Point(sx, sy);
        Point t = new Point(tx, ty);

        boolean[][] visited = new boolean[101][101];
        int[][] dist = new int[101][101];
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                visited[i][j] = false;
                dist[i][j] = (int) 1e9;
            }
        }
        Queue<Point> q = new LinkedList<>();
        q.add(s);
        visited[s.x][s.y] = true;
        dist[s.x][s.y] = 0;

        while (!q.isEmpty()) {
            Point u = q.remove();
            if (u.x == t.x && u.y == t.y) {
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

        @Override
        public int compareTo(Point other) {
            if (x == other.x)
                return Integer.compare(y, other.y);
            return Integer.compare(x, other.x);
        }

        ArrayList<Point> moves() {
            ArrayList<Point> moves = new ArrayList<>();
            for (int[] direction : knightMoves) {
                int nx = x + direction[0];
                int ny = y + direction[1];
                if (nx < 0 || nx > 100) continue;
                if (ny < 0 || ny > 100) continue;
                moves.add(new Point(x + direction[0], y + direction[1]));
            }
            return moves;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
