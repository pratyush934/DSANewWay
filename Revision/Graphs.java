import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Graphs {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static class Edge1 {
        int src;
        int dest;

        public Edge1(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static void createGraph() {

        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

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

        /* 2's neighour */
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.println(e.src + " --> " + e.dest);
        }

    }

    public static void bfsTraversal(ArrayList<Edge>[] graph) { /* O(n) --> O(V+E) */
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(0);

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!vis[curr]) {
                System.out.println(curr + " ");
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfsTraversal(ArrayList<Edge>[] graph, int curr, boolean vis[]) {
        /* visiting and printing */
        System.out.print(curr + "-->");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) { // Isko dhyan se dekhe
                dfsTraversal(graph, e.dest, vis);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean vis[]) { // O(V+E)
        if (src == dest)
            return true;

        vis[src] = true;

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[i].get(i);
            // e.dest --> src ban jayega aur usse puchenge
            if (!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) {
                return true;
            }
        }
        return false;
    }

    public static void bfsMain(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                bfsUtil(graph, vis);
            }
        }

    }

    public static void bfsUtil(ArrayList<Edge>[] graph, boolean vis[]) { /* O(n) --> O(V+E) */
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!vis[curr]) {
                System.out.println(curr + " ");
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfsMain(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            dfsUtil(graph, i, vis);
        }

    }

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean vis[]) {
        /* visiting and printing */
        System.out.print(curr + "-->");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) { // Isko dhyan se dekhe
                dfsUtil(graph, e.dest, vis);
            }
        }
    }

    public static boolean detectCycle(ArrayList<Edge1> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i])
                detectCycleUtil(graph, i, vis, -1);
        }

        return false;
    }

    private static boolean detectCycleUtil(ArrayList<Edge1> graph[], int curr, boolean vis[], int parent) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge1 e = graph[curr].get(i);

            // case 3 --> copy me dekhe
            if (!vis[e.dest]) {
                if(detectCycleUtil(graph, e.dest, vis, curr))
                    return true;
            }
            // case 1 --> copy me dekhe
            else if (vis[e.dest] && e.dest != parent) {
                return true;
            }
            // case 2 --> copy me dekhe ==> do nothing
        }

        return false;
    }

    public static boolean isBipartitie(ArrayList<Edge1> graph[]) {
        int col[] = new int[graph.length];
        for (int i = 0; i < col.length; i++) {
            col[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (col[i] != -1) {
                q.add(i);
                col[i] = 0;

                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge1 e = graph[curr].get(j); // for e.dest

                        if (col[e.dest] == -1) {
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        } else if (col[e.dest] == col[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
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
            }
            if (!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void topologicalSort(ArrayList<Edge1> graph[]) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                topSortUtil(graph, i, vis, s);
            }
        }

        while(!s.empty()) {
            System.out.print(s.pop()+"-->");
        }
    }
    private static void topSortUtil(ArrayList<Graphs.Edge1>[] graph, int curr, boolean[] vis, Stack<Integer> s) {
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge1 e = graph[curr].get(i);
            if(!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

   
    public static void kahnAlgo(ArrayList<Edge1> graph[]) {
        int indeg[] = new int[graph.length];
        calcIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<indeg.length; i++) {
            if(indeg[i] == 0) {
                q.add(i);
            }
        }

        //bfs 210
        while(!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr+"-->"); //topological sort ko print karo

            for(int i=0; i<graph[curr].size(); i++) {
                Edge1 e = graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    private static void calcIndeg(ArrayList<Edge1> graph[], int indeg[]) {
        for(int i=0; i<graph.length; i++) {
            int v = i;
            for(int j=0; j<graph[v].size(); j++) {
                Edge1 e = graph[v].get(j);
                indeg[e.dest]++;
            }
        }
    } 

    public static void printAllPath(ArrayList<Edge1> graph[], int src, int dest, String path) { //O(V^V)
        if(src == dest) {
            System.out.println(path+src);
            return;
        }

        for(int i=0; i<graph[src].size(); i++) {
            Edge1 e = graph[src].get(i);
            printAllPath(graph, e.dest, dest, path+src);
        }
    }

    static class Pair implements Comparable<Pair>{
        int n;
        int path;

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Graphs.Pair p2) {
            return this.path - p2.path;
        }
    }


    public static void dijkstraAlgo(ArrayList<Edge>[] graph, int src) { /* O(v^2) ---> O(V+ElogV) */
        int dist[] = new int[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE; //+infinity
            }
        }

        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        //loop
        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!vis[curr.n]) {
                vis[curr.n] = true;
                for(int i=0; i<graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dist[u] + wt < dist[v] ) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        //print all source to vertices shortest dist;
        for(int i=0; i<dist.length; i++) {
            System.out.print(dist[i]+"-->");
        }
        System.out.println();
    } 

    // Complete code for bellmanford algo

    public static void bellmanFord(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length];
        for(int i=0; i<dist.length; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        int V = graph.length;
        //algo
        for(int i=0; i<V-1; i++) { //O(V*E)
            //edges - O(E)
            for(int j=0; j<V; j++) {
                for(int k=0; k<graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }
        //print
        for(int i=0; i<dist.length; i++) {
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }

    static class MST implements Comparable<MST>{

        int v;
        int cost;

        public MST(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(MST m2) {
            return this.cost - m2.cost;
        }
    }

    public static void prims(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<MST> pq = new PriorityQueue<>();
        pq.add(new MST(0, 0));
        int finalCost = 0;

        while(!pq.isEmpty()) {
            MST curr = pq.remove();
            if(!vis[curr.v]) {
                vis[curr.v] = true;
                finalCost += curr.cost;

                for(int i=0; i<graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    pq.add(new MST(e.dest, e.wt));
                }
            }

        
        }
        System.out.println("Final cost of MST : " + finalCost);
    }


    public static void createGraph(int flights[][], ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }

    static class Info {
        int v, cost, stops;

        public Info(int v, int c, int s) {
            this.v = v;
            this.cost = c;
            this.stops = s;
        }
    }

    public static int cheapestFlight(int n, int flights[][], int src, int dest, int k) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights, graph);

        int dist[] = new int[n];
        for(int i=0; i<n; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while(!q.isEmpty()) {
            Info curr = q.remove();
            if(curr.stops > k) {
                break;
            }

            for(int i=0; i<graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
                // int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if(curr.cost + wt < dist[v] && curr.stops <= k) {
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }

        //dist[dest]
        if(dist[dest] == Integer.MAX_VALUE) return -1;
        else return dist[dest];

    }

    static class newEdge implements Comparable<newEdge>{
        int dest, cost;

        public newEdge(int d, int c) {
            this.dest = d;
            this.cost = c;
        }

        @Override
        public int compareTo(Graphs.newEdge o) {
           return this.cost - o.cost;
        }
    }

    public static int connectCities(int cities[][]) {
        PriorityQueue<newEdge> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[cities.length];

        pq.add(new newEdge(0, 0));
        int finalCost = 0;

        while(!pq.isEmpty()) {
            newEdge curr = pq.remove();
            if(!vis[curr.dest]) {
                vis[curr.dest] = true;
                finalCost += curr.cost;

                for(int i=0; i<cities[curr.dest].length; i++) {
                    if(cities[curr.dest][i] != 0) {
                        pq.add(new newEdge(i, cities[curr.dest][i]));
                    }
                }
            }
        }

        return finalCost;
    }

    //KRUSKAL'S ALGORITHM

    
    static class Union {
        
        // very optimised
        // time complexity --> O(4k)
        
        static class EdgeForSorting implements Comparable<EdgeForSorting> {
            int src, dest, wt;
    
            public EdgeForSorting(int s, int d, int wt) {
                src = s;
                dest = d;
                this.wt = wt;
            }
    
            @Override
            public int compareTo(EdgeForSorting o) {
                return this.wt - o.wt;
            }
    
            
        }
        
        static void createGraph(ArrayList<EdgeForSorting> edges) {
            edges.add(new EdgeForSorting(0, 1, 10));
            edges.add(new EdgeForSorting(0, 2, 15));
            edges.add(new EdgeForSorting(0, 3, 30));
            edges.add(new EdgeForSorting(1, 3, 40));
            edges.add(new EdgeForSorting(2, 3, 50));
        }

        static int n = 7;
        static int par[] = new int[n];
        static int rank[] = new int[n];
    
        public static void init() {
            for (int i = 0; i < n; i++) {
                par[i] = i;
            }
        }
    
        public static int find(int x) {
            if (x == par[x]) {
                return x;
            }
    
            return par[x] = find(par[x]);
        }
    
        public static void union(int a, int b) {
            int parA = find(a);
            int parB = find(b);
    
            if (rank[parA] == rank[parB]) {
                par[parB] = parA;
                rank[parA]++;
    
            } else if (rank[parA] < rank[parB]) {
                par[parA] = parB;
            } else {
                par[parB] = parA;
            }
        }

        public static void kruskalsMST(ArrayList<EdgeForSorting> edges, int V) {
            init();
            Collections.sort(edges);
            int mstCost = 0;
            int count = 0;

            for(int i=0; count < V-1; i++) {
                EdgeForSorting e = edges.get(i);
                // (src, dest, wt)

                int parA = find(e.src);
                int parB = find(e.dest);
                if(parA != parB) {
                    union(e.src, e.dest);
                    mstCost += e.wt;
                    count++;
                }
            }
            System.out.println(mstCost);
        }
        
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean vis[][] = new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, vis, image[sr][sc]);
        return image;
    }
    private void helper(int[][] image, int sr, int sc, int color, boolean[][] vis, int orgCol) {
        if(sc < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || vis[sr][sc] || image[sr][sc] != orgCol) {
            return;
        }

        //left
        helper(image, sr, sc-1, color, vis, orgCol);
        //right
        helper(image, sr, sc+1, color, vis, orgCol);
        //up
        helper(image, sr-1, sc, color, vis, orgCol);
        //down
        helper(image, sr+1, sc, color, vis, orgCol);
    }

    public static void main(String[] args) {


    }
}
