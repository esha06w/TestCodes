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

class Graph
{
    private LinkedList<Integer>[] adj;
    private int v;
    private int e;
    Graph(int v)
    {
        this.adj = new LinkedList[v];
        for(int i = 0;i < v;i++)
        {
            this.adj[i] = new LinkedList<Integer>();
        }
        this.v = v;
        this.e = 0;
    }
    public void addEdge(int w,int v)
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

class BFS
{
    boolean[] marked;
    BFS(Graph G,int s)
    {
        marked = new boolean[G.v()];
        bfs(G,s);
    }
    private void bfs(Graph G,int v)
    {
        marked[v] = true;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(v);
        while(q.size()!=0)
        {
            Integer i = q.poll();
            for(Integer j : G.adj(i))
            {
                if(!marked[j])
                {
                    marked[j] = true;
                    q.add(j);
                }
            }
            System.out.print(i+" ");
        }
    }
    
    public boolean hasPathTo(int v)
    {
        return marked[v]; 
    }
}

public class BreadthFirstSearch {
    public static void main(String[] args)
    {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter number of vertices");
        int vertices = obj.nextInt();
        Graph G = new Graph(vertices);
        System.out.println("Enter the conected edges. Press -1 to exit");
        int num1,num2;
        num1 = obj.nextInt();
        num2 = obj.nextInt();
        while(num1 != -1)
        {
            G.addEdge(num1, num2);
            num1 = obj.nextInt();
            if(num1 != -1)
                num2 = obj.nextInt();
        }
        System.out.println("Enter source");
        int s = obj.nextInt();
        BFS bfs = new BFS(G,s);
        System.out.println();
        System.out.println();
        System.out.println("Enter vertex to see if it is connected to the source?");
        int ver = obj.nextInt();
        boolean check = bfs.hasPathTo(ver);
        System.out.println(check);
        
    }
    
}
