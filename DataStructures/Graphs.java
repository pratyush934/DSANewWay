import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Graphs {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void creatingGraph1() {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        /* inserting ArrayList in each box of array */
        /* very important */
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 5));

        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        graph[4].add(new Edge(4, 2, 2));

        /* 2's neighours */
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.println(e.wt);
        }
    }

    public static void creatingGraph2(ArrayList<Edge> graph[]) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[5].add(new Edge(6, 5, 1));
    }

    public static void bfs(ArrayList<Edge> graph[]) { /* O(V+E) */
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(0);

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean vis[]) {
        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean vis[]) {
        /* O(V+E) */
        if (src == dest) {
            return true;
        }
        vis[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) {
                return true;
            }
        }
        return false;
    }

    public static void accessingBFSandDFS() {
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        creatingGraph2(graph);
        // bfs(graph);
        // dfs(graph, 0, new boolean[V]);
        System.out.println(hasPath(graph, 0, 5, new boolean[V]));
    }

    public static void bfsNew(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                bfsUtil(graph, vis);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge>[] graph, boolean vis[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfsNew(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            dfsUtil(graph, i, vis);
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean vis[]) {
        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    static class Edge1 {
        int src;
        int dest;

        public Edge1(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void creatingGraph3(ArrayList<Edge1> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge1(0, 1));
        graph[0].add(new Edge1(0, 2));
        graph[0].add(new Edge1(0, 3));

        graph[1].add(new Edge1(1, 0));
        graph[1].add(new Edge1(1, 2));

        graph[2].add(new Edge1(2, 0));
        graph[2].add(new Edge1(2, 1));

        graph[3].add(new Edge1(3, 0));
        graph[3].add(new Edge1(3, 4));

        graph[4].add(new Edge1(4, 3));
    }

    public static boolean detectCycle(ArrayList<Edge1>[] graph) { /* O(V+E) */
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                    /* cycle exists in one of the parts */
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge1>[] graph, boolean vis[], int curr, int par) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge1 e = graph[curr].get(i);
            /* case 3 */
            if (!vis[e.dest]) {
                if (detectCycleUtil(graph, vis, e.dest, curr))
                    return true;
            }
            /* case 1 */
            else if (vis[e.dest] && e.dest != par) {
                return true;
            }
            /* case 2 -> do nothing */
        }
        return false;
    }

    public static void accessingCycleDetection() {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge1> graph[] = new ArrayList[V];
        creatingGraph3(graph);
        System.out.println(detectCycle(graph));
    }

    public static void creatingGraph4(ArrayList<Edge1>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge1(0, 1));
        graph[0].add(new Edge1(0, 2));

        graph[1].add(new Edge1(1, 0));
        graph[1].add(new Edge1(1, 3));

        graph[2].add(new Edge1(2, 0));
        graph[2].add(new Edge1(2, 4));

        graph[3].add(new Edge1(3, 1));
        graph[3].add(new Edge1(3, 4));

        graph[4].add(new Edge1(4, 2));
        graph[4].add(new Edge1(4, 3));
    }

    public static boolean isBipartite(ArrayList<Edge1>[] graph) {
        /* AGAR GRAPH ME CYCLE NAHI HAI TO WO BIPARTITE HOGA */
        int col[] = new int[graph.length];
        for (int i = 0; i < col.length; i++) {
            col[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) { /* BFS */
                q.add(i);
                col[i] = 0; /* yellow */
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge1 e = graph[curr].get(j); /* e.dest */
                        if (col[e.dest] == -1) {
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        } else if (col[e.dest] == col[curr]) {
                            return false; /* NOT bipartite */
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void accessingBipartite() {

        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge1> graph[] = new ArrayList[V];
        creatingGraph4(graph);
        System.out.println(isBipartite(graph));
    }

    public static void creatingGraph5(ArrayList<Edge1> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge1(0, 2));

        graph[1].add(new Edge1(1, 0));

        graph[2].add(new Edge1(2, 3));

        graph[3].add(new Edge1(3, 0));
    }

    public static boolean isCycle(ArrayList<Edge1>[] graph) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCycleUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCycleUtil(ArrayList<Graphs.Edge1>[] graph, int curr, boolean[] vis, boolean[] stack) {
        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge1 e = graph[curr].get(i);
            if (stack[e.dest]) {
                return true;
            } else if (!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void accessingCycleInDG() {
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge1> graph[] = new ArrayList[V];
        creatingGraph5(graph);
        System.out.println(isCycle(graph));
    }

    public static void creatingGraph6(ArrayList<Edge1> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[2].add(new Edge1(2, 3));

        graph[3].add(new Edge1(3, 1));

        graph[4].add(new Edge1(4, 0));
        graph[4].add(new Edge1(4, 1));

        graph[5].add(new Edge1(5, 0));
        graph[5].add(new Edge1(5, 2));
    }

    public static void topSort(ArrayList<Edge1> graph[]) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topSortUtil(graph, i, vis, s);
            }
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    private static void topSortUtil(ArrayList<Graphs.Edge1>[] graph, int curr, boolean[] vis, Stack<Integer> s) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge1 e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static void accessingTopology() {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge1> graph[] = new ArrayList[V];
        creatingGraph6(graph);
        topSort(graph);
    }

    static void creatingGraph7(ArrayList<Edge1> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge1(2, 3));

        graph[3].add(new Edge1(3, 1));

        graph[4].add(new Edge1(4, 0));
        graph[4].add(new Edge1(4, 1));

        graph[5].add(new Edge1(5, 0));
        graph[5].add(new Edge1(5, 2));

    }

    public static void calcIndeg(ArrayList<Edge1> graph[], int indeg[]) {
        for (int i = 0; i < graph.length; i++) {
            int v = i;
            for (int j = 0; j < graph[v].size(); j++) {
                Edge1 e = graph[v].get(i);
                indeg[e.dest]++;
            }
        }
    }

    public static void topSortKahnAlgo(ArrayList<Edge1> graph[]) {
        int indeg[] = new int[graph.length];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }
        /* bfs */
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " "); /* topological ko print */

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge1 e = graph[curr].get(i);
                indeg[e.dest]--;
                if (indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    public static void accessingKahnAlgo() {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge1> graph[] = new ArrayList[V];
        creatingGraph7(graph);
        topSortKahnAlgo(graph);

    }

    static void creatingGraph8(ArrayList<Edge1> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge1(0, 3));

        graph[2].add(new Edge1(2, 3));

        graph[3].add(new Edge1(3, 1));

        graph[4].add(new Edge1(4, 0));
        graph[4].add(new Edge1(4, 1));

        graph[5].add(new Edge1(5, 0));
        graph[5].add(new Edge1(5, 2));
    }

    public static void printAllPath(ArrayList<Edge1> graph[], int src, int dest, String path) {
        if (src == dest) {
            System.out.println(path + dest);
            return;
        }

        for (int i = 0; i < graph[src].size(); i++) {
            Edge1 e = graph[src].get(i);
            printAllPath(graph, e.dest, dest, path + src);
        }
    }

    public static void accessingAllPath() {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge1> graph[] = new ArrayList[V];
        creatingGraph8(graph);
        int src = 5, dest = 1;
        printAllPath(graph, src, dest, "");
    }

    public static void creatingGraph9(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

    }

    static class Pair implements Comparable<Pair> {
        int n;
        int path;

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    public static void dijkstra(ArrayList<Edge> graph[], int src) { /* O(V+ElogV) */
        int dist[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.n]) {
                vis[curr.n] = true;
                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if (dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        /* print all source to vetices shortest dist */
        for (int i = 0; i < dist.length; i++) {
            System.out.println(dist[i] + " ");
        }
        System.out.println();
    }

    public static void accessingdijkstraAlgo() {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        creatingGraph9(graph);

        int scr = 0;
        dijkstra(graph, scr);
    }

    static void creatingGraph10(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }

    public static void bellmanFord(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        int V = graph.length;
        /* algo */ /* O(v) */
        for (int i = 0; i < V - 1; i++) {
            /* edges - O(E) */
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    /* u, v, wt */
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    public static void accessingBellmanFord() {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        creatingGraph10(graph);
        bellmanFord(graph, 0);
    }

    public static void creatingGraph11(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    static class Pair1 implements Comparable<Pair1> {
        int v;
        int cost;

        public Pair1(int v, int c) {
            this.v = v;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair1 p2) {
            return this.cost - p2.cost;
        }

    }

    public static void printMST(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair1> pq = new PriorityQueue<>();
        pq.add(new Pair1(0, 0));
        int finalCost = 0; /* MST Cost */

        while (!pq.isEmpty()) {
            Pair1 curr = pq.remove();
            if (!vis[curr.v]) {
                vis[curr.v] = true;
                finalCost += curr.cost;

                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair1(e.dest, e.wt));
                }
            }
        }
        System.out.println("Final Cost (minimum) " + finalCost);
    }

    public static void accessingPrism() {
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        creatingGraph11(graph);
        printMST(graph);
    }

    public static void creatingGraph12(int flights[][], ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }

    static class Info {
        int v;
        int cost;
        int stops;

        public Info(int v, int c, int s) {
            this.v = v;
            this.cost = c;
            this.stops = s;
        }
    }

    public static int cheapestFlight(int n, int flights[][], int src, int dest, int k) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[n];
        creatingGraph12(flights, graph);

        int dist[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.stops > k) {
                break;
            }

            for (int i = 0; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if (curr.cost + wt < dist[v] && curr.stops <= k) {
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }

        /* dist[dest] */
        if (dist[dest] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[dest];
        }
    }

    public static void accessingCheapestFlight() {
        int n = 4;
        int flights[][] = { { 0, 1, 100 }, { 1, 2, 200 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int src = 0, dst = 3, k = 1;
        System.out.println(cheapestFlight(n, flights, src, dst, k));

    }

    static class Edge2 implements Comparable<Edge2> {
        int dest;
        int cost;

        public Edge2(int d, int c) {
            this.dest = d;
            this.cost = c;
        }

        @Override
        public int compareTo(Edge2 e2) {
            return this.cost - e2.cost; /* ascending */
        }
    }

    public static int connectCities(int cities[][]) {
        PriorityQueue<Edge2> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[cities.length];

        pq.add(new Edge2(0, 0));
        int finalCost = 0;

        while (!pq.isEmpty()) {
            Edge2 curr = pq.remove();
            if (!vis[curr.dest]) {
                vis[curr.dest] = true;
                finalCost += curr.cost;

                for (int i = 0; i < cities[curr.dest].length; i++) {
                    if (cities[curr.dest][i] != 0) {
                        pq.add(new Edge2(i, cities[curr.dest][i]));
                    }
                }
            }
        }
        return finalCost;

    }

    public static void accessingConnectingCities() {
        int cities[][] = { { 0, 1, 2, 3, 4 },
                { 1, 0, 5, 0, 7 },
                { 2, 5, 0, 6, 0 },
                { 3, 0, 6, 0, 0 },
                { 4, 7, 0, 0, 0 } };

        System.out.println(connectCities(cities));
    }

    public static void creatingGraph13(ArrayList<Edge1> garph[]) {
        for (int i = 0; i < garph.length; i++) {
            garph[i] = new ArrayList<>();
        }
        garph[0].add(new Edge1(0, 2));
        garph[0].add(new Edge1(0, 3));

        garph[1].add(new Edge1(1, 0));

        garph[2].add(new Edge1(2, 1));

        garph[3].add(new Edge1(3, 4));
    }

    public static void topSort1(ArrayList<Edge1> graph[], int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge1 e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSort1(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static void dfs1(ArrayList<Edge1> graph[], int curr, boolean vis[]) {
        vis[curr] = true;
        System.out.print(curr + " ");

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge1 e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs1(graph, e.dest, vis);
            }
        }
    }

    //implementing Kosaraju     

    public static void kosaraju(ArrayList<Edge1> graph[], int V) {
        /* Step1 */
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topSort1(graph, i, vis, s);
            }
        }

        /* Step2 */
        @SuppressWarnings("unchecked")
        ArrayList<Edge1> transpose[] = new ArrayList[V];
        for (int i = 0; i < graph.length; i++) {
            vis[i] = false;
            transpose[i] = new ArrayList<Edge1>();
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge1 e = graph[i].get(j);
                transpose[e.dest].add(new Edge1(e.dest, e.src));
            }
        }

        /* Step3 */
        while (!s.isEmpty()) {
            int curr = s.pop();
            if (!vis[curr]) {
                System.out.print("SCC --> ");
                dfs1(transpose, curr, vis);
                System.out.println();
            }
        }
    }

    public static void accessingKosarajusAlgo() {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge1> graph[] = new ArrayList[V];
        creatingGraph13(graph);
        kosaraju(graph, V);
    }

    static void creatingGraph14(ArrayList<Edge1> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge1>();
        }
        graph[0].add(new Edge1(0, 1));
        graph[0].add(new Edge1(0, 2));
        graph[0].add(new Edge1(0, 3));

        graph[1].add(new Edge1(1, 0));
        graph[1].add(new Edge1(1, 2));

        graph[2].add(new Edge1(2, 0));
        graph[2].add(new Edge1(2, 1));

        graph[3].add(new Edge1(3, 0));
        graph[3].add(new Edge1(3, 4));
        graph[3].add(new Edge1(3, 5));

        graph[4].add(new Edge1(4, 3));
        graph[4].add(new Edge1(4, 5));

        graph[5].add(new Edge1(5, 3));
        graph[5].add(new Edge1(5, 4));

    }

    public static void dfsTarjan(ArrayList<Edge1> graph[], int curr, int par, int dt[], int low[], boolean vis[],
            int time) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge1 e = graph[curr].get(i); /* e.src --> e.dest */
            int neigh = e.dest;
            if (neigh == par) {
                continue;
            } else if (!vis[neigh]) {
                dfsTarjan(graph, neigh, curr, dt, low, vis, time);
                low[curr] = Math.min(low[curr], low[neigh]);
                if (dt[curr] < low[neigh]) {
                    System.out.println("Bridge : " + curr + "-----" + neigh);
                }
            } else {
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
        }
    }

    public static void tarjanBridge(ArrayList<Edge1> graph[], int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfsTarjan(graph, i, -1, dt, low, vis, time);
            }
        }
    }

    public static void accessingTargen() {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge1> graph[] = new ArrayList[V];
        creatingGraph14(graph);
        tarjanBridge(graph, V);

    }

    public static void creatingGraph15(ArrayList<Edge1> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge1(0, 1));
        graph[0].add(new Edge1(0, 2));
        graph[0].add(new Edge1(0, 3));

        graph[1].add(new Edge1(1, 0));
        graph[1].add(new Edge1(1, 2));

        graph[2].add(new Edge1(2, 0));
        graph[2].add(new Edge1(2, 1));

        graph[3].add(new Edge1(3, 0));
        graph[3].add(new Edge1(3, 4));

        graph[4].add(new Edge1(4, 3));
    }

    public static void dfsgetAP(ArrayList<Edge1> graph[], int curr, int par, int dt[], int low[], int time,
            boolean vis[], boolean ap[]) {
        
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;
        
        for(int i=0; i<graph[curr].size(); i++) {
            Edge1 e = graph[curr].get(i);
            int neigh = e.dest;

            if(par == neigh) {
                continue;
            } else if(vis[neigh]) {
                low[curr] = Math.min(low[curr], dt[neigh]);
            } else {
                dfsgetAP(graph, neigh, curr, dt, low, time, vis, ap);
                low[curr] = Math.min(low[curr], low[neigh]);
                if(par != -1 && dt[curr] <= low[neigh]) {
                    ap[curr] = true;
                }
                children++;
            }
        }
        if(par == -1 && children > 1) {
            ap[curr] = true;
        }
    }

    public static void getAP(ArrayList<Edge1> graph[], int V) {
        int dit[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];
        boolean ap[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfsgetAP(graph, i, -1, dit, low, time, vis, ap);
            }
        }
        /* print all APs */
        for(int i=0; i<V; i++) {
            if(ap[i]) {
               System.out.println(i);
            }
        }
    }

    public static void accessingArticulationP() {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge1> graph[] = new ArrayList[V];
        creatingGraph15(graph);
        getAP(graph, V);

    }

    public static void main(String[] args) {

        accessingArticulationP();
    }
}
