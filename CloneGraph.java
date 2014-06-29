/*Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/*/
/**
 * Definition for undirected graph.
 
 */
import java.util.*;

class UndirectedGraphNode {
      int label;
      ArrayList<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
  };
public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        //use HashMap record the <oldnode,newnode> pair
        //use queue to BFS
        UndirectedGraphNode newnode = new UndirectedGraphNode(0);
        UndirectedGraphNode pointer = newnode;
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        //Queue<UndirectedGraphNode> q2 = new LinkedList<UndirectedGraphNode>();
        if(node == null||node.neighbors == null){
            newnode = null;
            return newnode;
        }
        newnode.label = node.label;
        //q2.offer(pointer);
        q.offer(node);
        map.put(node,pointer);
        while(!q.isEmpty()){
            UndirectedGraphNode p = q.poll();
            //pointer = q2.poll();
            pointer = map.get(p);
            for(UndirectedGraphNode i : p.neighbors){
                //if the circle is self,do not create new node
                    if(i == p){
                        pointer.neighbors.add(pointer);
                    }
                    else{
                        //if the node is not visited,add neighbor as well as add to queue
                        if(!map.containsKey(i)){
                            UndirectedGraphNode nei = new UndirectedGraphNode(i.label);
                            pointer.neighbors.add(nei);
                        
                            q.offer(i);
                            //q2.offer(nei);
                            map.put(i,nei);
                        }
                        //if the node is visited,just add neighbor but not create new node and add to queue
                        else{
                            pointer.neighbors.add(map.get(i));
                        }
                    }
            }
            
        }
            
        
        
        return newnode;
    }
	

}
