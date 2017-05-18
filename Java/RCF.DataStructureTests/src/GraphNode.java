import java.util.HashMap;
import java.util.Set;

/**
 * @author rflec028
 *
 */
public class GraphNode extends TestClass{

	private HashMap<GraphNode,Integer> nodeMap;
	
	public GraphNode(){
		System.out.println("Node created!");
		nodeMap = new HashMap<GraphNode,Integer>();
	}
	
	//Queries and graph information:
	
	public GraphNode[] getConnectedNodes(){
		Set<GraphNode> connectedNodes = nodeMap.keySet();
		return (GraphNode[])connectedNodes.toArray();
	}
	
	public Boolean isConnected(GraphNode other){
		return nodeMap.containsKey(other);
	}
	
	public Integer dijkstraDistanceToNode(GraphNode other){
		//Implement me!
		//Use a different class to keep track of the spanning set.
		//Include method in new class to re-factor spanning set with all nodes.
		return 0;
	}
	
	//Searches through two layers. Implement Dijsktra algorithm later.
	public Integer simpleDistanceToNode(GraphNode other){
		if(other.equals(this)){return 0;}
		else if(isConnected(other)){
			return(nodeMap.get(other));
		}else{
			GraphNode[] testNodes = this.getConnectedNodes();
			
			System.out.println("A");
			int distance = 0;
			for(GraphNode x:testNodes){
				System.out.println(x.getName()+" to "+other.getName());
				if(x.isConnected(other)){
					System.out.println(x.getName()+" to "+other.getName());
					Integer tempDistance = x.simpleDistanceToNode(other)+this.simpleDistanceToNode(x);
					if(distance==-1 || tempDistance<distance){
						distance=tempDistance;}
				}
			
			}
			System.out.println("B");
			return distance;
		}
	}
	
	//Simple graph building methods:
	
	public void connect(GraphNode other,Integer distance){
		this.addSingleLink(other, distance,1);
		other.addSingleLink(this, distance,0);
	}
	
	public void addSingleLink(GraphNode other,Integer distance, int displayDist){
		nodeMap.put(other,distance);
		
		//This IF statement and int displayDist for testing and can be removed later.
		if(displayDist==1){System.out.println("Nodes "+this.getName()+" and "+other.getName()+" linked!\nDistance: "+nodeMap.get(other));
		}}
	
	
	

}
