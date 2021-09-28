package gabriel.pintea.g1094.composite;

import java.util.ArrayList;
import java.util.List;

public class Group extends AbstractNode {
	
	List<AbstractNode> nodes = new ArrayList<>();
	
	public Group() {
		super();
	}

	@Override
	public String getIpAddress() {
		String ipTable = new String();
		for(AbstractNode node : nodes) {
			ipTable += " " + node.getIpAddress();
		}
		return ipTable;
	}

	@Override
	public int getPort() {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getMaxConnections() {
		int maxPhysicalConnections = 0;
		for(AbstractNode node : nodes) {
			maxPhysicalConnections += node.getMaxConnections();
		}
		return maxPhysicalConnections;
	}

	@Override
	public boolean connect() {
		for(AbstractNode node : nodes) {
			if(!node.connect()) {
				System.out.println("Server running on port " + node.getPort() + 
						" failed to connect");
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean disconnect() {
		for(AbstractNode node : nodes) {
			if(!node.disconnect()) {
				System.out.println("Server running on port " + node.getPort() + 
						" failed to disconnect");
				return false;
			}
		}
		return true;
	}

	@Override
	public void addNewNode(AbstractNode node) {
		this.nodes.add(node);
		
	}

	@Override
	public void deleteNode(AbstractNode node) {
		this.nodes.remove(node);
		
	}

	@Override
	public AbstractNode getNode(int index) {
		return this.nodes.get(index);
	}

}
