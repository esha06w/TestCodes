/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ESHA
 */
import java.util.*;

class Graphs {
    LinkedList<Integer>[] adj;
    private int v;
    private int e;
    
    public Graphs(int v)
    {
        this.v = v;
        adj = new LinkedList[v];
        for(int i = 0;i < v;i++)
        {
            this.adj[i] = new LinkedList<Integer>();
        }
        this.e = 0;
    }
    
    public void addEdge(int v, int w)
    {
        this.adj[v].add(w);
        this.adj[w].add(v);
        this.e++;
    }
    
    public int v()
    {
        return this.v;
    }
    
    public int e()
    {
        return this.e;
    }
    
    public Iterable<Integer> adj(int v)
    {
        return this.adj[v];
    }
}

class DFS {
    private boolean[] marked;
    
    public DFS(Graphs G,int s)
    {
        this.marked = new boolean[G.v()];
        dfs(G,s);
    }
    
    private void dfs(Graphs G, int v)
    {
        marked[v] = true;
        System.out.println(v);
        for(Integer w : G.adj(v))
        {
            if(!marked[w])
                dfs(G,w);
        }
    }
    
    public boolean hasPathTo(int w)
    {
        return marked[w];
    }
    
}

public class DepthFirstSearch {
    public static void main(String[] args)
    {
        Scanner obj = new Scanner(System.in);
        int vertices;
        System.out.println("Enter number of vertices");
        vertices = obj.nextInt();
        Graphs G = new Graphs(vertices);
        DFS dfs;
        System.out.println("Enter the vertices to be connected. Press -1 to exit.");
        int num1 = obj.nextInt();
        int num2 = obj.nextInt();
        while(num1 != -1)
        {
            G.addEdge(num1,num2);
            num1 = obj.nextInt();
            if(num1 != -1)
                num2 = obj.nextInt();
        }
        System.out.println("Enter source");
        int source = obj.nextInt();
        dfs = new DFS(G,source);
        System.out.println();
        System.out.println();
        System.out.println("Enter vertex to see if it is connected to the source?");
        int ver = obj.nextInt();
        boolean check = dfs.hasPathTo(ver);
        System.out.println(check);
        
        
    }
    
}
