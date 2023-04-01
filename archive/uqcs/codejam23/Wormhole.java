package sol;

import com.github.nathanwn.jcp.io.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Wormhole {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        Point source = new Point(in.nextInt(), in.nextInt());
        Point sink = new Point(in.nextInt(), in.nextInt());
        int n = in.nextInt();
        Point[] points = new Point[2 * n + 2];
        int s = 0;
        int t = 2 * n + 1;
        points[s] = source;
        points[t] = sink;
        for (int i = 0; i < n; i++) {
            points[2 * i + 1] = new Point(in.nextInt(), in.nextInt());
            points[2 * i + 2] = new Point(in.nextInt(), in.nextInt());
        }

        Graph g = new Graph(2 * n + 2);

        g.addEdgeGivenCoordinates(s, t, points);

        for (int u = 1; u <= 2 * n; u++) {
            g.addEdgeGivenCoordinates(s, u, points);
            g.addEdgeGivenCoordinates(t, u, points);
        }

        for (int u = 1; u <= 2 * n; u += 2) {
            g.addEdge(u, u + 1, 1);

            for (int v = u + 2; v <= 2 * n; v++) {
                g.addEdgeGivenCoordinates(u, v, points);
                g.addEdgeGivenCoordinates(u + 1, v, points);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        long[] dist = new long[2 * n + 2];
        Arrays.fill(dist, (long) 1e18);
        pq.add(new Node(0, 0));
        dist[0] = 0;

        while (!pq.isEmpty()) {
            Node u = pq.remove();

            if (u.d > dist[u.id]) continue;

            if (u.id == 2 * n + 1) {
                out.println(u.d);
                return;
            }

            for (Edge e : g.adj.get(u.id)) {
                if (dist[e.v] > dist[u.id] + e.w) {
                    dist[e.v] = dist[u.id] + e.w;
                    pq.add(new Node(e.v, dist[e.v]));
                }
            }
        }

        throw new RuntimeException();
    }

    class Graph {
        int n;
        ArrayList<ArrayList<Edge>> adj;

        Graph(int n) {
            this.n = n;
            this.adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                this.adj.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v, long w) {
            adj.get(u).add(new Edge(u, v, w));
            adj.get(v).add(new Edge(v, u, w));
        }

        void addEdgeGivenCoordinates(int u, int v, Point[] points) {
            addEdge(u, v, points[u].manhattanDistance(points[v]));
        }
    }

    class Edge {
        int u;
        int v;
        long w;

        Edge(int u, int v, long w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    class Node implements Comparable<Node> {
        int id;
        long d;

        Node(int u, long d) {
            this.id = u;
            this.d = d;
        }

        @Override
        public int compareTo(Node node) {
            return Long.compare(d, node.d);
        }
    }

    class Point implements Comparable<Point> {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        long manhattanDistance(Point other) {
            return Math.abs(x - other.x) + Math.abs(y - other.y);
        }

        @Override
        public int compareTo(Point other) {
            if (x == other.x)
                return Integer.compare(y, other.y);
            return Integer.compare(x, other.x);
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
