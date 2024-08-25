package sol;

import com.github.nathanwn.jcp.io.InputReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class ShortestPath {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int s = in.nextInt();
        int t = in.nextInt();
        Graph g = new Graph(n);
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            g.addEdge(u, v, w);
        }

        int[] parent = new int[n];
        long[] dist = new long[n];

        final long INF = (long) 1e18;
        Arrays.fill(dist, INF);

        PriorityQueue<PQEntry> pq = new PriorityQueue<>();
        dist[s] = 0;
        pq.add(new PQEntry(s, 0));

        while (!pq.isEmpty()) {
            PQEntry entry = pq.remove();
            int u = entry.u;
            long d = entry.d;
            if (d > dist[u]) {
                continue;
            }
            if (u == t) {
                break;
            }
            for (Edge e : g.adj.get(u)) {
                int v = e.v;
                int w = e.w;
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    parent[v] = u;
                    pq.add(new PQEntry(v, dist[v]));
                }
            }
        }

        if (dist[t] == INF) {
            out.println(-1);
            return;
        }

        int p = t;
        ArrayList<Integer> path = new ArrayList<>();
        while (p != s) {
            path.add(p);
            p = parent[p];
        }
        path.add(s);
        Collections.reverse(path);
        out.printf("%d %d\n", dist[t], path.size() - 1);
        for (int i = 0; i < path.size() - 1; i++) {
            out.printf("%d %d\n", path.get(i), path.get(i + 1));
        }
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

        void addEdge(int u, int v, int w) {
            adj.get(u).add(new Edge(u, v, w));
        }
    }

    class Edge {
        int u;
        int v;
        int w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    class PQEntry implements Comparable<PQEntry> {
        int u;
        long d;

        public PQEntry(int u, long d) {
            this.u = u;
            this.d = d;
        }

        @Override
        public int compareTo(PQEntry other) {
            return Long.compare(d, other.d);
        }
    }
}
