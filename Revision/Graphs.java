import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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



    static void createGraph() {

        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        for(int i=0; i<V; i++) {
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
        for(int i=0; i<graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.println(e.src+" --> "+e.dest);
        }


    }

    public static void bfsTraversal(ArrayList<Edge>[] graph) { /* O(n) --> O(V+E) */
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(0);

        while(!q.isEmpty()) {
            int curr = q.remove();

            if(!vis[curr]) {
                System.out.println(curr+" ");
                vis[curr] = true;
                for(int i=0; i<graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfsTraversal(ArrayList<Edge>[] graph, int curr, boolean vis[]) {
        /* visiting and printing */
        System.out.print(curr+"-->");
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) { //Isko dhyan se dekhe
                dfsTraversal(graph, e.dest, vis);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean vis[]) { //O(V+E)
        if(src == dest) return true;

        vis[src] = true;

        for(int i=0; i<graph[src].size(); i++) {
            Edge e = graph[i].get(i);
            //e.dest --> src ban jayega aur usse puchenge
            if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        createGraph();
    }
}
