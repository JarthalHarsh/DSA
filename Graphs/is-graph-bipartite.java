//https://leetcode.com/problems/is-graph-bipartite/

class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        int color = 2;
        visited[0] = color;
        while(!que.isEmpty())
        {
            
            int val = que.poll();
            
            for(int i = 0; i<graph[val].length;i++)
            {
                 if(visited[graph[val][i]] == 0)
            {
                if(visited[val] == 2)
            {
                color = 3;
            }
            else
            {
                color = 2;
            }
                visited[graph[val][i]] = color;
                que.add(graph[val][i]);
            }
            else
            {
             if(visited[val] == visited[graph[val][i]])
                      {
                        return false;
                      }         
            }
            
            }
            if(que.isEmpty())
            {
                for(int i = 0; i<visited.length; i++)
                {
                    if(visited[i] == 0)
                    {
                        que.add(i);
                        visited[i] = color;
                        break;
                    }
                }

            }
        }
        
        // for(int i = 0; i<graph.length;i++)
        //     {
        //         for(int j = 0; j<graph[i].length; j++)
        //         {
        //               if(visited[i] == visited[graph[i][j]])
        //               {
        //                 return false;
        //               }       
        //         }
        //     }

        return true;
    }
}