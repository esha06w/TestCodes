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

class Graph3
{
    private LinkedList<Integer>[] adj;
    private int v;
    private int e;
    Graph3(int v,int e)
    {
       this.adj = new LinkedList[v]; 
       this.v = v;
       this.e = e;
       int i;
       for(i = 0;i < v;i++)
       {
          adj[i] = new LinkedList<Integer>(); 
       }
    }
    public void addEdge(int v,int w)
    {
        this.adj[v].add(w);
        //this.adj[w].add(v);
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

class DFS3
{
    private boolean[] marked;
    private Stack<Integer> res;
    DFS3(Graph3 G)
    {
        this.marked = new boolean[G.v()];
        this.res = new Stack<Integer>();
    }
    public void sort(Graph3 G)
    {
        int i;
        for(i = 0;i < G.v();i++)
        {
            if(!marked[i])
            {
                topologicalsort(G,i);
            }
        }
    }
    private void topologicalsort(Graph3 G, int v)
    {
        marked[v] = true;
        for(Integer w : G.adj(v))
        {
            if(!marked[w])
            {
                topologicalsort(G,w);
            }
        }
        res.push(v);
    }
    public void result()
    {
        while(res.size() != 0)
        {
            System.out.print(res.pop() + " ");
        }
    }
}

public class TopologicalSort {
    public static void main(String[] args)
    {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter number of vertices");
        int v = obj.nextInt();
        System.out.println("Enter number of edges");
        int e = obj.nextInt();
        Graph3 G = new Graph3(v,e);
        System.out.println("Enter edges");
        for(int i = 0;i < e;i++)
        {
            G.addEdge(obj.nextInt(), obj.nextInt());
        }
        DFS3 dfs = new DFS3(G);
        dfs.sort(G);
        dfs.result();
    }

    
}
