import java.util.ArrayList;
import java.util.LinkedList;
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
                if (detectCycleUtil(graph, e.dest, vis, curr))
                    return true;
            }
            // case 1 --> copy me dekhe
            else if (!vis[e.dest] && e.dest != parent) {
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

    public static void main(String[] args) {

        createGraph();
    }
}
